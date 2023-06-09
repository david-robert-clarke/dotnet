import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
   This program tests the DES cipher. Usage:
   java DESTest -genkey keyfile
   java DESTest -encrypt plaintext encrypted keyfile
   java DESTest -decrypt encrypted decrypted keyfile
*/
public class DESTest
{
   public static void main(String[] args)
   {
      try
      {
         if (args[0].equals("-genkey"))
         {
            KeyGenerator keygen 
               = KeyGenerator.getInstance("DES");
            SecureRandom random = new SecureRandom();
            keygen.init(random);
            SecretKey key = keygen.generateKey();
            ObjectOutputStream out = new ObjectOutputStream(
               new FileOutputStream(args[1]));
            out.writeObject(key);
            out.close();            
         }
         else
         {
            int mode;
            if (args[0].equals("-encrypt"))
               mode = Cipher.ENCRYPT_MODE;
            else
               mode = Cipher.DECRYPT_MODE;

            ObjectInputStream keyIn = new ObjectInputStream(
               new FileInputStream(args[3]));
            Key key = (Key) keyIn.readObject();
            keyIn.close();            

            InputStream in = new FileInputStream(args[1]);
            OutputStream out = new FileOutputStream(args[2]);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(mode, key);

            crypt(in, out, cipher);
            in.close();
            out.close();
         }
      }
      catch (IOException exception)
      {
         exception.printStackTrace();
      }
      catch (GeneralSecurityException exception)
      {
         exception.printStackTrace();
      }
      catch (ClassNotFoundException exception)
      {
         exception.printStackTrace();
      }
   }

   /**
      Uses a cipher to transform the bytes in an input stream
      and sends the transformed bytes to an output stream.
      @param in the input stream
      @param out the output stream
      @param cipher the cipher that transforms the bytes
   */
   public static void crypt(InputStream in, OutputStream out,
      Cipher cipher) throws IOException, GeneralSecurityException
   {
      int blockSize = cipher.getBlockSize();
      int outputSize = cipher.getOutputSize(blockSize);
      byte[] inBytes = new byte[blockSize];
      byte[] outBytes = new byte[outputSize];

      int inLength = 0;;
      boolean more = true;
      while (more)
      {
         inLength = in.read(inBytes);
         if (inLength == blockSize)
         {
            int outLength 
               = cipher.update(inBytes, 0, blockSize, outBytes);
            out.write(outBytes, 0, outLength);
            System.out.println(outLength);
         }
         else more = false;         
      }
      if (inLength > 0)
         outBytes = cipher.doFinal(inBytes, 0, inLength);
      else
         outBytes = cipher.doFinal();
      System.out.println(outBytes.length);
      out.write(outBytes);
   }
}     
