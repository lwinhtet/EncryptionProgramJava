
/*
* We're going to be utilizing all of the keys and characters from this ASCII table from the ranges of
* 32 to 126. That is the scope and we are going to neglect from 1 to 31 because they are kind of special. */
public class Main {
    public static void main(String[] args) {
        EncryptionProgram ep = new EncryptionProgram();
    }
}

/*
* A one-time pad (OTP) is a cryptographic technique used for encrypting and decrypting messages.
* It is a type of symmetric encryption where the encryption key is as long as the plaintext message
* and is used only once. The key is generated randomly and should never be reused.

Here's how the one-time pad encryption process works:
Key Generation: A random key, also known as the one-time pad, is generated. The key is a sequence of
* random binary digits (0s and 1s) that is at least as long as the plaintext message to be encrypted.

Encryption: Each bit of the plaintext message is combined with the corresponding bit of the one-time
* pad using a bitwise XOR (exclusive OR) operation. The result is the ciphertext, which is also a
* sequence of binary digits.

Decryption: To decrypt the ciphertext, the same one-time pad is used. Each bit of the ciphertext is
* combined with the corresponding bit of the one-time pad using the XOR operation. This retrieves the
* original plaintext message.

The security of the one-time pad relies on two main factors:
Perfect Secrecy: If the one-time pad is truly random, used only once, and kept secret, the resulting
* ciphertext provides perfect secrecy. This means that even with unlimited computational power, an attacker
* cannot determine any information about the plaintext without the key.

Key Management: The security of the one-time pad depends on the secure generation, distribution, and disposal
* of the one-time pads. If the keys are reused, predictable, or compromised, the security of the encryption
* is compromised.

While the one-time pad offers perfect secrecy, it has practical limitations, such as the need for a key
* as long as the message, the challenge of securely distributing keys, and the impracticality of generating
* truly random keys for large messages. As a result, the one-time pad is often used in specialized applications
* where security is paramount, such as military communications, rather than in everyday encryption scenarios.





* */
