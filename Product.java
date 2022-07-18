
			public class Produkt	
			{
				String Emri;
				double cmimi;
				public Produkt(){
					Emri="Empty Slot";
					cmimi=0;
					}
				public Produkt(String Emri, double  cmimi) {
					this.Emri = Emri;
					this.cmimi = cmimi;
				}
				public String display()	{
					String hapesira="";
					for(int i=0; i<(15-Emri.length()); i++){
						hapesira=hapesira+" ";
					}//hapesira mbushet me 15- gjatesine e emrit ne menyre qe te gjitha hapesirat te jene te rreshtuara;
					
				 return (Emri + hapesira +"| price: " + cmimi + "\n_____________________________");
					
				}

			}
			
			
