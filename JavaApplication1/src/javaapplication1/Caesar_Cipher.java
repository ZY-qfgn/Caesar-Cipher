
package javaapplication1;// location of the program

/**
 * IDE 8.2
 * @author Ziyi Huang
 * Caesar Cipher Assignment
 * October 1, 2020
 */
import java.io.*; // allow the program to get user input
public class Caesar_Cipher {
    
/**main method:
	 * This procedural method is called automatically and is used to organize the calling of other methods defined in the class
	 * 
	 * List of Local Variables
         * message - the original message input by user, used to store the message need to be encrypted and decrypted <type String>
         * encryptedMessage - used to store the encrypted message after shifting by the key, initialized as "" <type String>
         * decryptedMessage - used to store the decrypted message after shifting by the key, initialized as "" <type String>
         * breakCodeMessage - used to store an array of possible decrypted message after shifting by trying all the keys <type String[]>
         * key - the shift will be made from the original message <type int>
	 *
	 * @param args <type String>
	 * @throws IO Exception	
	 * @return void
	 */
	public static void main(String[]args) throws IOException{
		String message, encryptedMessage, decryptedMessage;//declare and initialize encryptedMessage and decryptedMessage
		String[] breakCodeMessage = new String[26];//declare array, length 26, 0 to 25
		int key;
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a message to encode: ");//prompt and get the user input
		message = br.readLine();
		System.out.println("Enter the number of shift you want to do, it should between 0 and 26: ");//prompt the user and get the key 
		key = Integer.parseInt(br.readLine());
                while (0>key|| key>26){//check if the key is in range
                    System.out.println("Please enter a number in the range: ");
                    key = Integer.parseInt(br.readLine());
                }
		encryptedMessage = encode(message, key);//run the encode method
                System.out.println("Encrypted Message: " + encryptedMessage);

		breakCodeMessage = breakCode(encryptedMessage, breakCodeMessage);//run the breakCode method
		System.out.println("Breaked Message: ");
		for (int i = 0; i < 26; i++) {//output all the possible decrpted code
			System.out.println("The attempted key: " + i + ", decrpted code: " + breakCodeMessage[i] + "\t");
		}      
                
                System.out.println("Please enter the message you want to decode: ");
		message = br.readLine();
		System.out.println("Enter the number of shift you want to do, it should between 0 and 26: ");
		key = Integer.parseInt(br.readLine());
                while (0>key|| key>26){
                    System.out.println("Please enter a number in the range: ");
                    key = Integer.parseInt(br.readLine());
                }
                decryptedMessage = decode(message, key);//run the decode method
		System.out.println("Decoded Message: " + decryptedMessage);
                System.out.println();
	}
        
	/**encode method:
	 * This functional method encrypts the message by shifting each character in the message forward by key units
	 *
         * List of Local Variables
         * ch - uesd to store each character in the message <type char>
         * eM - used to store the encrypted message after shifting by the key <type String>
         * 
	 * @param message - the original message input by user, used to store the message need to be encrypted and decrypted <type String>
         * key - the shift will be made from the original message <type int>
	 * @return eM - the encrypted message after shifting by the key <type String>
	 */	
	public static String encode(String message, int key){   //take a string and a number and returns a new string shifted forward
		char ch;
                String eM = "";
		for(int i = 0; i < message.length(); i++){
			ch = message.charAt(i);		
			if(ch >= 'a' && ch <= 'z'){
				ch = (char)(ch + key);
				if(ch > 'z'){
					ch = (char)(ch - 'z' + 'a' - 1);
				}
				eM += ch;
                        } 
			else if(ch >= 'A' && ch <= 'Z'){
				ch = (char)(ch + key); 
				if(ch > 'Z'){
					ch = (char)(ch - 'Z' + 'A' - 1);
				}
				eM += ch;
			}
			else {
				eM += ch;
			}
		}
		return eM;		
	}
        
        /**decode method:
	 * This functional method decrypts the message by shifting each character in the message backward by key units
	 *
         * List of Local Variables
         * ch - uesd to store each character in the message <type char>
         * 
	 * @param message - the original message input by user, used to store the message need to be encrypted and decrypted <type String>
         * decryptedMessage - used to store the decrypted message after shifting by the key, passed by reference <type String>
         * key - the shift will be made from the original message <type int>
	 * @return decryptedMessage - the decrypted message after shifting by the key <type String>
	 */	
        public static String decode(String message, int key){ //take a string and a number and returns a new string shifted backward
		char ch;
                String dM = "";
		for(int i = 0; i < message.length(); i++){
			ch = message.charAt(i);		
			if(ch >= 'a' && ch <= 'z'){
				ch = (char)(ch - key);
				if(ch < 'a'){
					ch = (char)(ch + 'z' - 'a' + 1);
				}
				dM += ch;
			}
			else if(ch >= 'A' && ch <= 'Z'){
				ch = (char)(ch - key); 
				if(ch < 'A'){
					ch = (char)(ch + 'Z' - 'A' + 1);
				}
				dM += ch;
			}
			else {
				dM += ch;
			}
		}
		return dM;
	}

        /**breakCode method:
	 * This functional method tries to break the code through trying to shift by all the possible keys
	 *
         * List of Local Variables
         * ch - uesd to store each character in the message <type char>
         * 
	 * @param message - the original message input by user, used to store the message need to be encrypted and decrypted <type String>
         * decryptedMessage - used to store the decrypted message after shifting by the key, passed by reference <type String>
         * key - the shift will be made from the original message <type int>
	 * @return breakCodeMessage -  an array of possible decrypted message after shiftiing by trying all the keys <type String[]>
	 */
	public static String[] breakCode(String encryptedMessage, String[] breakCodeMessage){
		char ch;
                String breakedMessage = "";
		for (int j = 0; j < 26; j++) {
			breakedMessage= decode(encryptedMessage, j);
                        breakCodeMessage[j] = breakedMessage;
			breakedMessage = "";
			
		}
		return breakCodeMessage;	
	}
}








