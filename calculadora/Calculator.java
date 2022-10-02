import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Calculator {

	static int optionMenu = 0;
	static int optionMenu2 = 0;
	static String messagePath = "=== Resultado === \n";

	public static int getSum(int num1, int num2){
		int sumando = num1 + num2;
		System.out.println(messagePath + num1 + " + " + num2 + " = " + sumando);
		return sumando;
	}
	
	public static int getRest(int num1, int num2){
		int restando = num1 - num2;
		System.out.println(messagePath + num1 + " - " + num2 + " = " + restando);
		return restando;
	}
	
	public static int getMulti(int num1, int num2){
		int multiplicando = num1 * num2;
		System.out.println(messagePath + num1 + " x " + num2 + " = " + multiplicando);
		return multiplicando;
	}
	
	public static int getDivi(int num1, int num2){
		if(num2 == 0){
			System.out.println(messagePath + "El número " + num1 + " no se puede dividir\npor " + num2 + " cero ...");
			System.exit(-1);
		}

		int dividiendo = num1 / num2;
		System.out.println(messagePath + num1 + " : " + num2 + " = " + dividiendo);

		return dividiendo;
	}
	
	public static int messageNumbers1() throws IOException{
		System.out.println("Ingrese el 1er número");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());

		return num1;
	}

	public static int messageNumbers2() throws IOException{
		System.out.println("Ingrese el 2do número");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int num2 = Integer.parseInt(br2.readLine());

		return num2;
	}

	public static void messageCalculator() throws IOException{
		System.out.println("");
		System.out.println("===== Calculator =====");
		System.out.println("=== Ingrese el número del menú === ");
		System.out.println("");
		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");
		System.out.println("5. Apagar calculadora");
		System.out.println("");

		BufferedReader op = new BufferedReader(new InputStreamReader(System.in));
		optionMenu = Integer.parseInt(op.readLine());
	}

	public static void messageFinish() throws IOException{
		System.out.println("");
		System.out.println("===== Seguro que quieres apagar la calculadora? =====");
		System.out.println("=== Ingrese el número del menú === ");
		System.out.println("");
		System.out.println("1. Si");
		System.out.println("2. No");
		System.out.println("");

		BufferedReader op = new BufferedReader(new InputStreamReader(System.in));
		optionMenu2 = Integer.parseInt(op.readLine());
	}

	public static void getOption(int option) throws IOException{
		if(option > 5) System.out.println(" === Ingresa una opción correcta! <1-5> === ");
		return;
	}

	public static void main(String[] args) throws IOException {
		do{
			do{
				messageCalculator();
				getOption(optionMenu);			
			}while(optionMenu > 5);

			switch (optionMenu) {
				case 1:
					getSum(messageNumbers1(), messageNumbers2());
				break;

				case 2:
					getRest(messageNumbers1(), messageNumbers2());
				break;

				case 3:
					getMulti(messageNumbers1(), messageNumbers2());
				break;

				case 4:
					getDivi(messageNumbers1(), messageNumbers2());
				break;

				case 5:
				do{
					messageFinish();
					if(optionMenu2 == 1) {
						System.out.println("Calculator is off !!!");
						System.exit(-1);
					}
				}while(optionMenu2 > 2);
				break;

				default:
				break;
		}
		}while(optionMenu2 == 2);
	}
}