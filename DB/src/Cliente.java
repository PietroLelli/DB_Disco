import java.sql.Date;

public class Cliente {

	private String CF;
	private String Nome;
	private String Cognome;
	private java.util.Date DataNascita;
	private String Email;
	private String Telefono;
	private int IdLocale;
	
	public Cliente() {
		
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
	public java.util.Date getDataNascita() {
		return DataNascita;
	}
	public void setDataNascita(java.util.Date date) {
		DataNascita = date;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public int getIdLocale() {
		return IdLocale;
	}
	public void setIdLocale(int idLocale) {
		IdLocale = idLocale;
	}
	
	
}
