import java.util.Arrays;

// Jonathan Carbonneau section A

public class BinaryNumber {
	//this int is the same as data[]
	private int[] innerArray;
	
	private int length;
	

	// decalres a fixed len array and populatis it with zero.
	// untested
	BinaryNumber(int length){
		this.length = length;
		this.innerArray = new int[length];
		Arrays.fill(innerArray, 0);
	}
	//chaining constructor creates a biary nuber array from a str uses above for the rest
	//untested
	BinaryNumber(String str){
		this(str.length());
		this.innerArray = stringToBinary(str);

	}
	

	// getters and setters
	public int[] getInnerArray() {
		return innerArray;
	}
	//retuns len
	public int getLength() {
		return length;
	}
	// sets len
	public void setLength(int length) {
		this.length = length;
	}
	// getter that trys to get the idex trows a error if it fails
    public void setInnerArray(int[] innerArray) {
		this.innerArray = innerArray;
	}
    
	public int getDigit(int index) {
		try {
			return getInnerArray()[index];
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Index Out Of Bounds Exception");
			return 0;
		}
		
	}
	// converts strings to binary
	public int[] stringToBinary(String str) {
		int[] tmp = new int[str.length()];
		for (int i =0; i< this.getLength(); i++) {
			tmp[i] = Character.getNumericValue(str.charAt(i));
		}
		return tmp;
	}
	// a two sting that converts arrays two string
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i =0; i< this.getLength(); i++) {
			s.append(this.getDigit(i));
		}
		return s.toString();
		
	}
	//converts binary to decimal check the for loop for a possible index error
	public int toDecimal(){
		int decNum = 0;
		int base = 1;
		for (int i = getLength()-1; i>=0; i--) {
			decNum += getInnerArray()[i] * base;
            base = base * 2;
		}
		return decNum;
	}
	//bitshift 
	public void bitShift(int direction, int amount) {
		if (direction == 1){
			innerArray = Arrays.copyOfRange(innerArray, 0 , getLength() - amount);
		}else if (direction == -1) {
			int[] tmpArr = new int[getLength() + amount];
			Arrays.fill(tmpArr, 0);
			for (int i = 0; i < innerArray.length; i++) {
				tmpArr[i] = innerArray[i];
			 }
			setInnerArray(tmpArr);
		}else {
			System.out.println("Invalid Direction");
		}
		setLength(innerArray.length);
	}
	//bit or
	static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		//leadZeros(bn1, bn2);
		System.out.println(Arrays.toString(bn2.innerArray));
		int[] tmpArr = new int [Math.max(bn1.getInnerArray().length, bn2.getInnerArray().length)];
		for (int i = tmpArr.length-1; i >= 0; i--) {
			if (bn1.getDigit(i) == 1 || bn2.getDigit(i) == 1) {
				tmpArr[i]= 1;
			}else{
				tmpArr[i]= 0;
			}
		 } 
		return tmpArr;
	}
	//bit and
	static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		//leadZeros(bn1, bn2);
		int[] tmpArr = new int [Math.max(bn1.getInnerArray().length, bn2.getInnerArray().length)];
		for (int i = tmpArr.length-1; i >= 0; i--) {
			if (bn1.getDigit(i) == 1 && bn2.getDigit(i) == 1) {
				tmpArr[i]= 1;
			}else{
				tmpArr[i]= 0;
			}
		 } 
		return tmpArr;
	}
	// make the arrays the same len
	static void makeSame(BinaryNumber bn1, BinaryNumber bn2) {
		int[] tmpArr = new int [Math.max(bn1.getLength(), bn2.getLength())];
		Arrays.fill(tmpArr, 0);
		if (bn1.getLength()>bn2.getLength()) {
			System.arraycopy(bn2.getInnerArray(), 0, tmpArr, tmpArr.length - bn2.getLength(), bn2.getLength());
			bn2.setInnerArray(tmpArr);
			bn2.setLength(tmpArr.length);
		}else if (bn1.getLength()<bn2.getLength()) {
			System.arraycopy(bn1.getInnerArray(), 0, tmpArr, tmpArr.length - bn1.getLength(), bn1.getLength());
			bn1.setInnerArray(tmpArr);
			bn1.setLength(tmpArr.length);
		}
		
		
	}
	// add two binary arrays.
	public void add(BinaryNumber bn2) {
		makeSame(this,bn2);
		
		int[] firstArr = this.getInnerArray();
		int[] secondArr = bn2.getInnerArray();
		
        int[] result = new int[firstArr.length + 1];
        int bitSum, carry = 0, i;
        for (i = firstArr.length - 1; i >= 0; i--) {
            bitSum = firstArr[i] + secondArr[i] + carry;
            result[i + 1] = bitSum % 2;
            carry = bitSum / 2;
        }
        result[0] = carry;
        this.setInnerArray(result);
        this.setLength(result.length);

	}

	
	public static void main(String[] args)
    {
//       String numberString    = "1010";
//       String numberStringOne = "1010";
//       BinaryNumber billy = new BinaryNumber(numberString);
//       BinaryNumber joe = new BinaryNumber(numberStringOne);
////        System.out.println(billy.toDecimal());
////        System.out.println(billy.toString());
////        System.out.println(billy.getDigit(2));
////        billy.bitShift(1, 1);
////        System.out.println(Arrays.toString(billy.innerArray));
//        System.out.println("pre add "+ billy.toString());
//        billy.add(joe);
//        System.out.println("post add "+billy.toString()); 
//        System.out.println(billy.toDecimal());
////        System.out.println("bit or  "+ Arrays.toString(billy.bwor(billy, joe)));
//        System.out.println("bit and  "+Arrays.toString(billy.bwand(billy, joe)));
//        
        
        
        
    }
	

}
