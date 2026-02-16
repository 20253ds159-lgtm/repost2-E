void main() {
    Scanner sc = new Scanner(System.in);
    Alumno[] alumno = new Alumno[25];
    ProcesoAlumnos procesoAlumnos = new ProcesoAlumnos();

    int opcion = 0;

    do {
        IO.println("Menu");
        IO.println("1) Alta alumno");
        IO.println("2) Buscar por ID (solo activos)");
        IO.println("3) Actualizar promedio por ID (solo activos)");
        IO.println("4) Baja lógica por ID");
        IO.println("5) Listar activos");
        IO.println("6) Reportes");
        IO.println("0) Salir");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                procesoAlumnos.altaAlumno(alumno);
                break;
            case 2:
                procesoAlumnos.buscarId(alumno);
                break;
            case 3:
                procesoAlumnos.actualizarPromedio(alumno);
                break;
            case 4:
                procesoAlumnos.darDebajaAAlumno(alumno);
                break;
            case 5:
                procesoAlumnos.listaActivos(alumno);
                break;
            case 6:
                procesoAlumnos.reporte(alumno);
                break;
            case 0:
                IO.println("Hasta la proxima");
                break;
            default:
                IO.println("Opcion invalida");
                break;
        }
    } while (opcion != 0);
}