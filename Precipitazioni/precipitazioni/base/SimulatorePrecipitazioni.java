package base;

public class SimulatorePrecipitazioni {

	public static void main (String[] args){
		Precipitazioni p = new Precipitazioni();
		VisualizzatoreMatrice vm = new VisualizzatoreMatrice();

		p.addVisualizzatore(vm);
		p.eseguiSimulazione();
	}
}