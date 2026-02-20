//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Gato botas= new Gato("Botas");
        Perro bruno= new Perro("Bruno");

//Herencia
        botas.comer();
        botas.hacerSonido();
        System.out.println("-------------------");
        bruno.comer();
        bruno.hacerSonido();

        Animal[] animales= new Animal[3];
        animales[0]=new Perro("Rufus");
        animales[1] = new Gato("Honey");
        animales[2] = new Perro("Solovino");
//Poliformismo
        for(Animal animal: animales){
            System.out.println("-------");
            animal.comer();
            animal.hacerSonido();
        }

//Cast, solo para hacer uso de los metodos de perro, a pesar de que anmal1 es un objeto de Animal
        Animal animal1= new Perro("nicky");
        Perro perr1 = (Perro)animal1;
        perr1.marcarTerritorio();


    }
}



class Animal {

    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }


    public void comer(){
        System.out.println(nombre+ " Esta comiendo");
    }

    public void hacerSonido(){
        System.out.println(nombre+ " Esta haciendo un sonido");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


class Gato extends Animal {

    public Gato(String nombre){
        super(nombre);
    }

    @Override
    public void hacerSonido(){
        System.out.println(getNombre() +" Esta maullando ");
    }
}



class Perro extends Animal{

    public Perro(String nombre) {
        super(nombre);
    }
    @Override
    public void hacerSonido(){
        System.out.println(getNombre()+ " Esta ladrando");
    }

    public void marcarTerritorio(){
        System.out.println(getNombre() + " Esta alanzado la patita");
    }
}