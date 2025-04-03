package misinterfaces;
public class Main {
	public static void main(String  args[])
	{
		int num = 14;
		
		num = procedure(a -> {return a+1;} , num);
		System.out.println(num);
		
		num = procedure((a) -> {return a+56;} , num);
		System.out.println(num);
		
		int numero =45;
		
		numero = funcionOperation(j -> {return j % 5;}, numero);
		System.out.println(numero);
	}
	
	public static int procedure(Funcion f, int numero)
	{
		return f.aumento(numero);
	}
	
	public static int funcionOperation(Operation o, int Numero) {
		return o.calculate(Numero);
	}
}
