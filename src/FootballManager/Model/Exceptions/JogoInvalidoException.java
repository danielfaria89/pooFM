package FootballManager.Model.Exceptions;

public class JogoInvalidoException extends Exception{
    public JogoInvalidoException(){
        super();
    }

    public JogoInvalidoException(String str){
        super(str);
    }
}
