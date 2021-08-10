import java.io.BufferedReader;
import java.io.InputStreamReader;

class CalculadoraPolinomio{
	// Classe calculadora de polinômios que gerará o objeto calculadora2 para cálculos em cima da equação de segundo grau
	public double a,b,c,delta,raiz1,raiz2;
	
	// métodos set e get para as variáveis da classe CalculadoraPolinomio:
	void setA(double a) {this.a = a;}
	double getA() {return this.a;}
	
	void setB(double b) {this.b = b;}
	double getB() {return this.b;}
	
	void setC(double c) {this.c = c;}
	double getC() {return this.c;}
	
	void setDelta(double delta) {this.delta = delta;}
	double getDelta() {return this.delta;}
	
	void setRaiz1(double raiz1) {this.raiz1 = raiz1;}
	double getRaiz1() {return this.raiz1;}
	
	void setRaiz2(double raiz2) {this.raiz2 = raiz2;}
	double getRaiz2() {return this.raiz2;}
	
	// métodos para os cálculos de delta e para as duas raízes:
	void Delta(double a,double b,double c) {
		double b2 = Math.pow(b, 2);
		double resposta = b2 - 4*a*c;
		setDelta(resposta);
	}
	
	void Raiz1(double delta,double a,double b) {
		double Rdelta = Math.sqrt(delta);
		double dividendo = (b * -1) + Rdelta;
		double resposta = dividendo / (2 * a);
		setRaiz1(resposta);
	}
	
	void Raiz2(double delta,double a,double b) {
		double Rdelta = Math.sqrt(delta);
		double dividendo = (b * -1) - Rdelta;
		double resposta = dividendo / (2 * a);
		setRaiz2(resposta);
	}
}


public class Calculadorajava{
	// Classe calculadora de polinômios que gerará o objeto calculadora1 para contas com operações binárias:
	public double num1, num2, resultado;
	
	// métodos set e get para as variáveis da classe CalculadoraJava:
	void setnum1(double numero) {this.num1 = numero;}
	double getnum1() {return this.num1;}
	
	void setnum2(double numero) {this.num2 = numero;}
	double getnum2() {return this.num2;}
	
	void setResultado(double resultado) {this.resultado = resultado;}
	double getResultado() {return this.resultado;}
	
	// métodos para os cálculos das diferentes operações binárias:
	void soma(double num1,double num2) {
		double resultado = num1 + num2;
		setResultado(resultado);
	}
	
	void subtracao(double num1,double num2) {
		double resultado = num1 - num2;
		setResultado(resultado);
	}
	
	void multiplicacao(double num1,double num2) {
		double resultado = num1 * num2;
		setResultado(resultado);
	}
	
	void divisao(double num1,double num2) {
		double resultado = num1 / num2;
		if(num2 == 0) {
			System.out.println("A resposta é indefinida");
		}
		else {
			setResultado(resultado);
		}
	}
	
	void exponenciacao(double num1,double num2) {
		double resultado = Math.pow(num1, num2);
		setResultado(resultado);
	}
	
	void resto(double num1,double num2) {
		double resultado = num1 % num2;
		setResultado(resultado);
	}
	
	// método main do programa:
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Calculadorajava calculadora1 = new Calculadorajava();
		CalculadoraPolinomio calculadora2 = new CalculadoraPolinomio();
		
		while(true) {
			System.out.println("1 - para calculadora básica;\n2 - para calculadora de polinômios;\n0 - para sair.");
			String UserInput = br.readLine();
			
			if(UserInput.length() > 1) {System.out.println("Comando inválido!");}
			
			else if(UserInput.equals("1")) {
				// início da calculadora básica:
				System.out.println("Calculadora básica...");
				
				// recebimento de inputs:
				System.out.println("Digite a operação à ser feita (+ , - , * , / , ** ou %)");
				String UserOperation = br.readLine();
					
					
				System.out.println("Digite o primeiro número da operação:");
				String Usernum1s = br.readLine();

				double Usernum1 = Double.parseDouble(Usernum1s);
				calculadora1.setnum1(Usernum1);
				double num1 = calculadora1.getnum1();
					
				System.out.println("Digite o segundo número da operação:");
				String Usernum2s = br.readLine();
					
				double Usernum2 = Double.parseDouble(Usernum2s);
				calculadora1.setnum2(Usernum2);
				double num2 = calculadora1.getnum2();
					
				// chamada dos métodos para os diferentes cálculos e outputs finais;
				if(UserOperation.equals("+")) {
					calculadora1.soma(num1,num2);
					double resultado = calculadora1.getResultado();
					System.out.printf("A soma entre %.2f e %.2f é: %.2f%n",num1,num2,resultado);
				}
					
				else if(UserOperation.equals("-")) {
					calculadora1.subtracao(num1,num2);
					double resultado = calculadora1.getResultado();
						System.out.printf("A subtração entre %.2f e %.2f é: %.2f%n",num1,num2,resultado);
				}
					
				else if(UserOperation.equals("*")) {
					calculadora1.multiplicacao(num1,num2);
					double resultado = calculadora1.getResultado();
					System.out.printf("A multiplicação entre %.2f e %.2f é: %.2f%n",num1,num2,resultado);
				}
				
				else if(UserOperation.equals("/")) {
					calculadora1.divisao(num1,num2);
					double resultado = calculadora1.getResultado();
					double teste = calculadora1.getnum2();
					if(teste == 0) {
						continue;
					}
					else {
						System.out.printf("A divisão entre %.2f e %.2f é: %.2f%n",num1,num2,resultado);
					}
					
				}
				
				else if(UserOperation.equals("**")) {
					calculadora1.exponenciacao(num1,num2);
					double resultado = calculadora1.getResultado();
					System.out.printf("A exponenciação de %.2f elevado a %.2f é: %.2f%n",num1,num2,resultado);
				}
				
				else if(UserOperation.equals("%")) {
					calculadora1.resto(num1,num2);
					double resultado = calculadora1.getResultado();
					System.out.printf("O resto da divisão entre %.2f e %.2f é: %.2f%n",num1,num2,resultado);
				}
					
				else {System.out.printf("%s é um comando inválido.%n",UserOperation);}
				}// fim da calculadora básica
			
			else if(UserInput.equals("2")) {
				// início da calculadora de polinômios:
				System.out.println("Calculadora de polinômio...");
				
				// recebimento de inputs:
				System.out.println("Digite o valor de a");
				String UsernumaS = br.readLine();
				double UserNumA = Double.parseDouble(UsernumaS);
				calculadora2.setA(UserNumA);
					
				System.out.println("Digite o valor de b");
				String UsernumbS = br.readLine();
				double UserNumB = Double.parseDouble(UsernumbS);
				calculadora2.setB(UserNumB);
					
				System.out.println("Digite o valor de c");
				String UsernumcS = br.readLine();
				double UserNumC = Double.parseDouble(UsernumcS);
				calculadora2.setC(UserNumC);
				
				double a = calculadora2.getA();
				double b = calculadora2.getB();
				double c = calculadora2.getC();
					
				System.out.printf("polinômio: %.0fx^2 + %.0fx + %.0f = 0%n",a,b,c);
				calculadora2.Delta(a, b, c);
				double delta = calculadora2.getDelta();
					
					
				if(a == 0) {
					System.out.println("A resposta é indefinida");
				}
					
				else if(delta < 0) {
					System.out.printf("Resultado do delta:%.2f%n",delta);
					System.out.println("Delta negativo não há como encontar raizes reais");
				}
					
				else {
					System.out.printf("Resultado do delta:%.2f%n",delta);
					calculadora2.Raiz1(delta, a, b);
					calculadora2.Raiz2(delta, a, b);
					
					double raiz1 = calculadora2.getRaiz1();
					double raiz2 = calculadora2.getRaiz2();
				
					System.out.printf("Resultado das duas raízes: %.2f e %.2f.%n",raiz1,raiz2);
					}
				}// fim da calculadora de polinômios

			else if(UserInput.equals("0")) {
				System.out.println("Até logo!");
				break;
			}
			else {System.out.println("Comando inválido!");}
		}// fim do loop principal
	}
}
