//kodi nuk eshte i kopjuar nga interneti por i perkthyer ne anglisht dhe i permisuar me tej!!

import java.util.*;
import java.io.*;
public class Main{
	//ky kod eshte i ngjashem me te tjeret pervec faktit qe lista afishohet ne ekran sic eshte e plot bashke me elementet bosh
		static String input;
		static int nrIProdukteve,k;
		public static void main (String args[]) 
			{
				String Emri;
				double cmimi=0.0;
				Scanner scanner = new Scanner(System.in);  
				ArrayList<Produkt> obj = new ArrayList<>();
				 Produkt[] prod = new Produkt[10];
				 for(int i = 0; i < 10; i++){
					prod[i]= new Produkt();
				}
				prod[0]= new Produkt("Prod 1", 300);
				prod[1]= new Produkt("Prod 2", 500);
				prod[2]= new Produkt("Prod 3", 250);
				prod[3]= new Produkt("Prod 4", 900);
					for (int i = 0; i < 10; i++){
					obj.add(prod[i]);
					} 
				System.out.println("Default list (4/10): \n_____________________________");
					for(Produkt obj1 : obj){
						System.out.println(obj1.display());
				      }  //krijimi dhe printimi i listes se perpara ndryshimeve
					  try{
					System.out.println("\nType in \"Add\", \"Edit\" or \"Delete\" to customize the list: ");  
					  input =(scanner.nextLine());}catch(InputMismatchException e){}
					while(!input.equals("Add") || !input.equals("Edit") || !input.equals("Delete")){
					if (input.equals("Add") || input.equals("Edit") || input.equals("Delete")){
							break;
						}try{
					System.out.println("\nTry Again: ");  
						input =(scanner.nextLine());}catch(InputMismatchException e){}
				}
				int n=10;
				do
				{
					while (input.equals("Add")){
						int m=0; //inicializohet m-ja per te pare sa "Empty Slot"-s ka lista
							for( int i=0; i < n; i++ ){
							if(obj.get(i).Emri=="Empty Slot"){
							m++;
							}
							}
							if(m==0){
								System.out.println("\nThe list is full");
								promptPerTeVazhduar();
								break;
							}
						//kodi per te shtuar nqs ka me shume se 0 empty slots
						if(m>0){try{
						System.out.println("\nHow many products do you wish to add (up to "+m+ "): ");
						nrIProdukteve = Integer.parseInt(scanner.nextLine());}catch(NumberFormatException e){System.out.println("\nWrong input"); 
						k=0;//nqs nuk rifreskohet k-ja ne cdo error do vazhdonte cikli for per nrIProdukteve te meparshem
						promptPerTeVazhduar();break;}	
							while(nrIProdukteve>(m)){
						    	if(nrIProdukteve<=(m)){
								break; //behet kapercimi tek shtimi nqs numri i shkruajtur i perputhet numrit te produkteve (ndalon ciklin while)
							}try{
							System.out.println("\n No more than "+m);
							nrIProdukteve = Integer.parseInt(scanner.nextLine());}catch(NumberFormatException e){System.out.println("\nInput i gabuar"); k=0; promptPerTeVazhduar();}
						}
						 k= nrIProdukteve;
					for( int i=0; i < n; i++ ){
						if(obj.get(i).Emri=="Empty Slot" && k>0){ //vendoset produkti i ri ne cdo empty slot
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
							try{
							System.out.println("\nSet the price: "); 
							cmimi=Double.parseDouble(scanner.nextLine());
						obj.get(i).Emri = Emri;
						obj.get(i).cmimi= cmimi;
						k=k-1; //limitohet numri i vendosjeve deri ne sa kerkon user-i
						}catch(NumberFormatException e){
								System.out.println("\nWrong input"); i=i-1;
								promptPerTeVazhduar();}
						
						}
					}
				}
				break;
					}
						while (input.equals("Edit")){
		 				 //kodi per te ndryshuar nje produkt sipas emrit
						 System.out.println("\nType the name of the product that you wanna edit: "); 
						 input= scanner.nextLine();
						 int j = 1;//indeximi i numrit te objektit qe po Editn nqs jane me shume se nje me te njejtin emer
						 int m = 0;
						 for (int i = 0; i < n; i++) {
								if (obj.get(i) != null && obj.get(i).Emri.equals(input)){
									m++; //merret numri i produkteve qe kane kete emer(input)
								}
						 }
						 if (m>0){
						 for (int i = 0; i < n; i++) {
							if (obj.get(i) != null && obj.get(i).Emri.equals(input)){try{
							System.out.println("\nType the name of the ("+ (j++)+") product: ");
							Emri= scanner.nextLine();
							System.out.println("\nSet the price: ");
								cmimi= Double.parseDouble(scanner.nextLine());
								obj.get(i).Emri = Emri;
							    obj.get(i).cmimi= cmimi;}catch(NumberFormatException e){
								System.out.println("\nWrong input"); i--; j--;
								promptPerTeVazhduar();}
							}
						}
					}

						else if (m==0) {
							System.out.println("\n\nThis product doesn't exist");
							promptPerTeVazhduar();
							}
					}while (input.equals("Delete")){
						System.out.println("\nType the name of the product you wanna delete"); 
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
							obj.get(i).Emri="Empty Slot";
							obj.get(i).cmimi=0;
							}//behet zevendesimi i informacioneve te produkteve qe doni te Deletehni me empty slot dhe 0
						  }
						}
						else {
							System.out.println("\nThis product doesn't exist");
							promptPerTeVazhduar();
							} 
						}
					System.out.println("\n\nThe customized list: \n_____________________________");
						 for(Produkt obj1 : obj){
								System.out.println(obj1.display());
						 }  //printimi i listes pas cdo ndryshimi
					System.out.println("\nType in \"Add\", \"Edit\" or \"Delete\" to customize the list: ");  
						input =(scanner.nextLine());
						while(!input.equals("Add") || !input.equals("Edit") || !input.equals("Delete")){
							if (input.equals("Add") || input.equals("Edit") || input.equals("Delete")){
							break;
							}
								System.out.println("\nTry Again: ");  
								input =(scanner.nextLine());
							}	
					}while(input.equals("Add") || input.equals("Edit") || input.equals("Delete"));
			}
		public static void promptPerTeVazhduar(){
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nPress \"ENTER\" to continue...");
				scanner.nextLine();
			}
}
