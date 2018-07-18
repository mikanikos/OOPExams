package soluzione;

public class SimulatorePrecipitazioni {

	public static void main (String[] args){
		Precipitazioni p = new Precipitazioni();
		Visualizzatore vm = new VisualizzatoreMatrice();
		Visualizzatore vg = new VisualizzatoreGrafico();
		Visualizzatore vi = new VisualizzatoreGraficoIstogramma();

		p.aggiungiVisualizzatore(vm);
		p.aggiungiVisualizzatore(vg);
		p.aggiungiVisualizzatore(vi);

		p.eseguiSimulazione();
	}
}