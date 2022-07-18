

import java.util.*;
import java.io.*;
public class Main{
		static String input;
		static int nrIProdukteve;
		public static void main (String args[]) 
			{
				String Emri;
				double cmimi=0.0;
				Scanner scanner = new Scanner(System.in);  
				ArrayList<Produkt> obj = new ArrayList<>();//ndryshimi i ketij kodi nga te tjerat eshte se produktet hidhen ne nje arraylist 
				//por e cila eshte dinamike dhe nuk i tregon elementet bosh
				 Produkt[] prod = new Produkt[10];
				prod[0]= new Produkt("Prod 1", 300);
				prod[1]= new Produkt("Prod 2", 500);
				prod[2]= new Produkt("Prod 3", 250);
				prod[3]= new Produkt("Prod 4", 900);
					for (int i = 0; i < 4; i++){
					obj.add(prod[i]);
                }
				System.out.println("Default list (4/10): \n_____________________________");
					for(Produkt obj1 : obj){
						System.out.println(obj1.display());
				      }  //printimi i listes perpara ndryshimeve
					  try{
					System.out.println("\nType in \"Add\", \"Edit\" or \"Delete\" to modify the list: ");  
					  input =(scanner.nextLine());}catch(InputMismatchException e){}
					while(!input.equals("Add") || !input.equals("Edit") || !input.equals("Delete")){
					if (input.equals("Add") || input.equals("Edit") || input.equals("Delete")){
							break;
						}
					System.out.println("\nTry Again: ");  
						input =(scanner.nextLine());
				}
				int	n=4;
				do
				{
					while (input.equals("Add")){
							if((10-n)==0){
								System.out.println("\nThe list is full");
								promptPerTeVazhduar();
								break;
							}
						//kodi per te shtuar
						try{
						System.out.println("\nHow many products do you wish to add (up to "+(10-n)+ "): ");
						nrIProdukteve = Integer.parseInt(scanner.nextLine());}catch(NumberFormatException e){
								System.out.println("\nWrong input");
								promptPerTeVazhduar();break;}
							while(nrIProdukteve>(10-n)){
						    	if(nrIProdukteve<=(10-n)){
								break;
							}try{
							System.out.println("\n No more than "+(10-n));
							nrIProdukteve = Integer.parseInt(scanner.nextLine());}catch(NumberFormatException e){
								System.out.println("\nWrong input");
								promptPerTeVazhduar();}
							}
							int z=n + nrIProdukteve;
							

					for( int i=n; i <z; i++ ){
						try{
						if(i+1==1){
						System.out.println("\nType the name of the first product you wanna add: ");
						}
						if(i+1==2){
						System.out.println("\nType the name of the second product you wanna add:");
						}
						if(i+1==3){
						System.out.println("\nType the name of the third product you wanna add:");
						}
						else if(i+1>3){
						System.out.println("\nType the name of the "+ (i+1) + "th product you wanna add");
						}//could use switch but fuck it
							Emri=(scanner.nextLine());
							System.out.println("\nSet the price	"); 
							cmimi=Double.parseDouble(scanner.nextLine());
						obj.add(prod[i] =new Produkt(Emri, cmimi));
						n=n+1;
						
						}catch(NumberFormatException e){
								System.out.println("\nWrong input");  i=i-1;
								promptPerTeVazhduar();}
						}
					break;
					}
						while (input.equals("Edit")){
		 				 //kodi per te ndryshuar nje produkt sipas emrit
						 System.out.println("\nType the name of the product you wanna edit: "); 
						 input= scanner.nextLine();
						 int j = 1;
						 int m = 0;
						 for (int i = 0; i < n; i++) {
								if (obj.get(i) != null && obj.get(i).Emri.equals(input)){
									m++;
								}
						 }
						 if (m>0){
						 for (int i = 0; i < n; i++) {
							if (obj.get(i) != null && obj.get(i).Emri.equals(input)){try{
							System.out.println("\nGive the new name of the ("+ (j++)+") product: ");
							Emri= scanner.nextLine();
							System.out.println("\nSet the price: ");
							cmimi= Double.parseDouble(scanner.nextLine());
								obj.get(i).Emri = Emri;
								obj.get(i).cmimi= cmimi;}catch(NumberFormatException e){
								System.out.println("\nWrong input"); i--;j--;
								promptPerTeVazhduar();}
							}
						}
					}

						else if (m==0) {
							System.out.println("\n\nThis product doesn't exist");
							promptPerTeVazhduar();
							}
					}while (input.equals("Delete")){
						System.out.println("\nType the name of the product you wanna delete: "); 
							input= scanner.nextLine();
						int m=0;
						for (int i = 0; i < n; i++) {
							if (obj.get(i) != null && obj.get(i).Emri.equals(input)){
							m++;
							}
						}
						if(m>0){
						for (int i = 0; i < n; i++) {
							if (obj.get(i) != null && obj.get(i).Emri.equals(input)){
							obj.remove(i); //e mira e ketij kodi nga tjetri eshte se lista ze me pak memorje dhe perdoret metoda .remove(index) per Deleterjen
							n=n-1;
							i=i-1;
							}
						  }
						}
						else {
							System.out.println("\nThis product doesn't exist");
							promptPerTeVazhduar();
								}
						}
					System.out.println("\n\nThe customized list ("+ n+"/10): \n_____________________________");
						 for(Produkt obj1 : obj){
								System.out.println(obj1.display());
						 }  //printing the list after every change
						 try{
					System.out.println("\nType in \"Add\", \"Edit\" or \"Delete\" to modify the list: ");  
						 input =(scanner.nextLine());}catch(InputMismatchException e){}
						while(!input.equals("Add") || !input.equals("Edit") || !input.equals("Delete")){
							if (input.equals("Add") || input.equals("Edit") || input.equals("Delete")){
							break;
							}try{
								System.out.println("\nTry Again: ");  
							input =(scanner.nextLine());}catch(InputMismatchException e){}
							}	
					}while(input.equals("Add") || input.equals("Edit") || input.equals("Delete"));
			}
		public static void promptPerTeVazhduar(){
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nPress \"ENTER\" to continue...");
				scanner.nextLine();
			}
}
