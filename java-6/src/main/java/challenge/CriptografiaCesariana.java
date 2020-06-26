package challenge;

public class CriptografiaCesariana implements Criptografia {
    public final char [] charMap = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n'
                                   ,'o','p','q','r','s','t','u','v','w','x','y','z',' '};
    int x = 0;
    String encripted = "", decripted = "", msg = "";
    private final int SALTO = 3;
    @Override
    public String criptografar(String texto) {
    	validarTexto(texto);
    	texto = texto.toLowerCase();
    	
    	for(int i=0; i < texto.length(); i++) {
			
			//search for the character on the map and get its index
			while(texto.charAt(i) != charMap[x]) {
				//Case it doesn't find the character in the map
				if(x > 25){
					break;
				}else{
					x++;
				}
				
			};	
				//Case index out of range
				if(x + SALTO > 26 && x < 25) {
					x = x - 26;
					encripted = encripted+ charMap[x + SALTO];
				}else {
					//Case the character isn't a letter
					if(x > 25) {
						encripted = encripted + texto.charAt(i);
					}else {
						encripted = encripted + charMap[x + SALTO];
					}
				}
			x = 0;	
		}
		return encripted;
    }

    @Override
    public String descriptografar(String texto) {
    	validarTexto(texto);
    	texto = texto.toLowerCase();
    	
        for(int i=0; i < texto.length(); i++) {

            //search for the character on the map and get its index
            while(texto.charAt(i) != charMap[x]) {
                if(x > 25){
                    break;
                }else{
                    x++;
                }
            };
            //Case of negative index
            if(x < SALTO) {
                x = x + 26;
                decripted = decripted + charMap[x-SALTO];
            }else {
                //Case the character isn't a letter
                if(x > 25) {
                    decripted = decripted + texto.charAt(i);
                }else {
                    decripted = decripted + charMap[x - SALTO];
                }
            }
            x = 0;
        }
        return decripted;
    }
    
    private void validarTexto(String texto) {
        if(texto.isEmpty()){
            throw new IllegalArgumentException();
        }
        if(texto.equals(null)){
            throw new NullPointerException();
        }
    }
}