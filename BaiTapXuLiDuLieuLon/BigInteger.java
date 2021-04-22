import java.util.ArrayList;

public class BigInteger {
    private DigitList digits;
    private int sign;

    public BigInteger() {
        this.digits = null;
        this.sign = 1;
    }

    public BigInteger(DigitList L) {
        this.digits = L;
        this.sign = 1;
    }

    public BigInteger(int i, DigitList L) {
        this.digits = L;
        this.sign = sgn(i);
    }

    public BigInteger(int i) {
        this.digits = DigitList.digitize(Math.abs(i));
        this.sign = sgn(i);
    }

    public BigInteger(String str) {
        if (str.charAt(0) == '-') {
            str = str.substring(1);
            this.digits = DigitList.digitize(str);
            this.sign = -1;
        } else {
            this.digits = DigitList.digitize(str);
            this.sign = 1;
        }
    }

    public DigitList getDigits() {
        return this.digits;
    }

    public int getSign() {
        return this.sign;
    }

    public void setDigits(DigitList digits) {
        this.digits = digits;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    private int sgn(int i) {
        if (i < 0)
            return -1;
        else
            return 1;
    }

    public int length() {
        if (this.digits == null)
            return 0;
        else
            return this.digits.length();
    }

    public BigInteger copy() {
        if (this.digits == null)
            return new BigInteger(0);
        else
            return new BigInteger(this.sign, this.digits.copy());
    }

    public BigInteger trimDigit() {
        return new BigInteger(this.sign, DigitList.trimDigitList(this.digits));
    }

    public boolean equals(Object obj) {
        if (obj instanceof BigInteger) {
            BigInteger other = (BigInteger) obj;
            if (this.sign == other.sign && DigitList.compareDigitLists(this.digits, other.digits) == 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (this.digits != null) {
            String integer = "";
            DigitList tmp = this.digits;
            integer = tmp.getDigit() + integer;
            tmp = tmp.getNextDigit();
            while (tmp != null) {
                integer = tmp.getDigit() + integer;
                tmp = tmp.getNextDigit();
            }
            return ((this.sign == -1) ? "-" : "") + integer;
        } else
            return "";
    }
	
	public BigInteger leftDigits(int n) {
        return new BigInteger(this.digits.leftDigits(n));
    }

    public BigInteger rightDigits(int n) {
        return new BigInteger(this.digits.rightDigits(n));
    }

    public BigInteger shift(int n) {
		if (n < 1)
            return this;
        else {
            BigInteger clone = this.copy();
            clone.digits = new DigitList(0, clone.digits);
            return clone.shift(n - 1);
        }
    }

    /******************************** STUDENT'S CODE ********************************/

    public BigInteger add(BigInteger other) {
        if (this.sign == other.sign)
            return new BigInteger(this.sign, DigitList.addDigitLists(0, this.digits, other.digits));
        else{
			if( DigitList.compareDigitLists( this.digits, other.digits) == 0){
				return new BigInteger(1, DigitList.subDigitLists(0, this.digits, other.digits));
			}
			else if(DigitList.compareDigitLists( this.digits, other.digits) == 1){
				return new BigInteger(this.sign, DigitList.subDigitLists(0, this.digits, other.digits));
			}
			else {
				return new BigInteger(other.sign, DigitList.subDigitLists(0, other.digits, this.digits));
			}  
        }
    }

    public BigInteger sub(BigInteger other) {
        if (this.sign != other.sign)
            return new BigInteger(this.sign, DigitList.addDigitLists(0, this.digits, other.digits));
        else{
			if( DigitList.compareDigitLists( this.digits, other.digits) == 0){
				return new BigInteger(1, DigitList.subDigitLists(0, this.digits, other.digits));
			}
			else if(DigitList.compareDigitLists( this.digits, other.digits) == 1){
				return new BigInteger(this.sign, DigitList.subDigitLists(0, this.digits, other.digits));
			}
			else {
				return new BigInteger(other.sign*(-1) ,DigitList.subDigitLists(0, other.digits, this.digits));
			}  
        }
    }    

    public BigInteger mul(BigInteger other) {
   
		int dodai = this.digits.length() - other.digits.length();
		
		if(dodai > 0){			
			int diff = this.digits.length() - other.digits.length();
			DigitList temp = other.digits;
			while (temp.getNextDigit() != null){
				temp = temp.getNextDigit();
			}
			for (int i = 0; i < diff; i++){
				temp.setNextDigit(new DigitList());
				temp = temp.getNextDigit();
			}
		}

		if(dodai < 0){
			DigitList temp = this.digits;
			int diff = other.digits.length() - this.digits.length();
			while (temp.getNextDigit() != null){
				temp = temp.getNextDigit();
			}
			for (int i = 0; i < diff; i++){
				temp.setNextDigit(new DigitList());
				temp = temp.getNextDigit();
			}
		}
		
        if(this.digits.length() == 1 && other.digits.length() == 1){
			return new BigInteger(this.digits.getDigit()*other.digits.getDigit()).trimDigit();
		}
	
		int n = this.digits.length() / 2;		

		BigInteger xl = this.leftDigits(n);
        BigInteger xr = this.rightDigits(this.digits.length() - n);
        BigInteger yl = other.leftDigits(n);
        BigInteger yr = other.rightDigits(other.digits.length() - n);
		
		BigInteger V1 =  xl.mul(yl);
		BigInteger V2 = (xr.mul(yl).add(xl.mul(yr))).shift(n);
		BigInteger V3 = xr.mul(yr).shift(2*n);
		
		return new BigInteger(this.sign*other.sign,V1.add(V2).add(V3).digits).trimDigit();
			
    }

    public static BigInteger pow(BigInteger X, BigInteger Y) {
		if (Y.digits.getDigit() == 1){
			return X;
		}
		return X.mul(pow(X,Y.sub(new BigInteger(1))));
    }

    public static BigInteger factorial(BigInteger X) {
		if(X.digits.length() == 1 && X.digits.getDigit() == 0)
			return new BigInteger(1,DigitList.digitize(1));
		return X.mul(factorial(X.sub(new BigInteger(1))));
    }

    public static BigInteger computeValue(ArrayList<BigInteger> operandArr, ArrayList<Character> operatorArr) {
		BigInteger output = operandArr.get(0);
        for (int j = 0; j < operatorArr.size(); j++) {
            switch (operatorArr.get(j)) {
                case '+':
                    output = output.add(operandArr.get(j + 1));
                    break;
                case '-':
					output = output.sub(operandArr.get(j + 1));
                    break;
                case '*':
					output = output.mul(operandArr.get(j + 1));
                    break;
                default:
                    break;
            }
        }
        return output;
    }
}