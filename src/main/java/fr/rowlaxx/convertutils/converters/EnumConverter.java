package fr.rowlaxx.convertutils.converters;

import java.lang.reflect.Field;
import java.util.Objects;

import fr.rowlaxx.convertutils.Convert;
import fr.rowlaxx.convertutils.Return;
import fr.rowlaxx.convertutils.SimpleConverter;
import fr.rowlaxx.convertutils.annotations.EnumMatcher;
import fr.rowlaxx.utils.generic.ReflectionUtils;
import fr.rowlaxx.utils.generic.destination.Destination;

@SuppressWarnings("rawtypes")
@Return(canReturnInnerType = true)
public class EnumConverter extends SimpleConverter<Enum>{
	
	//Constructeurs
	public EnumConverter() {
		super(Enum.class);
	}
	
	@Convert
	public <T extends Enum<T>> T toEnum(String string, Destination<T> destination) {
		
		//On regarde pour l'annotation ValueMatcher
		EnumMatcher enumMatcher;	
		String[] possibleNames;
		for (Field field : destination.getDestinationClass().getDeclaredFields()) {
			if (!field.isEnumConstant())
				continue;
			
			enumMatcher = field.getDeclaredAnnotation(EnumMatcher.class);
			if (enumMatcher == null)
				continue;
			
			possibleNames = enumMatcher.possibleMatchs();
			if (possibleNames.length == 0)
				possibleNames = new String[] {field.getName()};
			
			for (String possibleName : possibleNames) {
				if (enumMatcher.caseSensitiv() && !Objects.equals(possibleName, string))
					continue;
				if (!enumMatcher.caseSensitiv() && !possibleName.equalsIgnoreCase(string))
					continue;	
				return ReflectionUtils.tryGet(field, null);
			}
		}
		
		//On regarde pour la methode toString
		final T[] values = destination.getDestinationClass().getEnumConstants();
		for (T value : values)
			if (Objects.equals(value.toString(), string))
				return value;
		
		//On regarde pour la méthode name
		for (T value : values)
			if (Objects.equals(string, ((Enum<?>)value).name()))
				return value;
		
		return null;
	}
}