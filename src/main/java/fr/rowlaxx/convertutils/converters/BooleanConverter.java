package fr.rowlaxx.convertutils.converters;

import fr.rowlaxx.convertutils.Convert;
import fr.rowlaxx.convertutils.Return;
import fr.rowlaxx.convertutils.SimpleConverter;

@Return(canReturnInnerType = false)
public class BooleanConverter extends SimpleConverter<Boolean> {

	public BooleanConverter() {
		super(Boolean.class);
	}
	
	@Convert
	public boolean toBoolean(String string) {
		return Boolean.parseBoolean(string);
	}
	
	@Convert
	public Boolean toBoolean(int b) {
		if (b == 0)
			return false;
		if (b == 1)
			return true;
		return null;
	}
	
	@Convert
	public Boolean toBoolean(byte b) {
		if (b == 0)
			return false;
		if (b == 1)
			return true;
		return null;
	}

	@Convert
	public Boolean toBoolean(short b) {
		if (b == 0)
			return false;
		if (b == 1)
			return true;
		return null;
	}

	@Convert
	public Boolean toBoolean(long b) {
		if (b == 0)
			return false;
		if (b == 1)
			return true;
		return null;
	}
	
	@Convert
	public Boolean toBoolean(char b) {
		if (b == 'n' || b == 'N')
			return false;
		if (b == 'y' || b == 'Y')
			return true;
		return null;
	}

	@Convert
	public Boolean toBoolean(double b) {
		if (b == 0)
			return false;
		if (b == 1)
			return true;
		return null;
	}
	
	@Convert
	public Boolean toBoolean(float b) {
		if (b == 0)
			return false;
		if (b == 1)
			return true;
		return null;
	}
}