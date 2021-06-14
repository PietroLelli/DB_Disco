import java.sql.Date;

public class Dipendente {

	private String CF;
	private String Nome;
	private String Cognome;
	private String Residenza;
	private java.util.Date DataNascita;
	private String Telefono;
	private String Mansione;
	private int IdLocale;
	private int IdBar;
	
	public Dipendente() {
		
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getResidenza() {
		return Residenza;
	}
	public void setResidenza(String residenza) {
		Residenza = residenza;
	}
	public java.sql.Date getDataNascita() {
		return (Date) DataNascita;
	}
	public void setDataNascita(java.sql.Date date) {
		DataNascita = date;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getMansione() {
		return Mansione;
	}
	public void setMansione(String mansione) {
		Mansione = mansione;
	}
	public int getIdLocale() {
		return IdLocale;
	}
	public void setIdLocale(int idLocale) {
		IdLocale = idLocale;
	}
	public int getIdBar() {
		return IdBar;
	}
	public void setIdBar(int idBar) {
		IdBar = idBar;
	}
	
	
}
