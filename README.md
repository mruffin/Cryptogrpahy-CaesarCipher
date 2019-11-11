# Cryptography-CaesarCipher


In cryptography, a Caesar cipher, is one of the simplest and most widely known encryption techniques. It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet. For example, with a right shift of 3, A would be replaced by D, B would become E, and so on. The method is named after Julius Caesar, who used it in his private correspondence.

Implement a Caesar Cipher in a language of your choice. Your program should provide both encryption and decryption functions. Your program should accept three parameters: key, function, and message. 
These parameters are defined as follows:

• Key: indicates the amount by which the original alphabet is shifted. Your program is expected to support only positive shift values.

• Function: indicates whether encryption or decryption is being performed: encrypt, decrypt

• Message: indicates the original message to be encrypted or the cipher text that is to be decrypted. This will be a text string including spaces. You may assume a maximum length of 255 characters.


In this section, you will extend your code to support encryption and decryption with two substitutionalphabet. You may do this by adding an additional mode parameter. The mode parameter may be either “one” or “two” to indicate encryption with a one or two keys. When encrypting with two keys, the encryption process would alternate between each key, when encrypting and decrypting. For example, given the following command: ‘Caesar two 2 3 encrypt secret’, the word secret would be encrypted with two substitution alphabets: key=2, key=3, resulting in the following cipher text: uheugw.


Advanced Cryptography:

You may assume that the original text was encrypted with one key, but the cipher text may not include repeated characters. Your cryptanalysis program should still be able to successfully decrypt the cipher text.
