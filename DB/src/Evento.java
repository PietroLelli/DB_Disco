
public class Evento {
	private String NomeArte;
	private java.sql.Date Data;
	private java.sql.Time OrarioInizio;
	private java.sql.Time OrarioFine;
	private float Supplemento;
	private int IdLocale;
	
	private String Nome;
	private String Cognome;
	private String GenereMusicale;
	
	public String getNomeArte() {
		return NomeArte;
	}
	public void setNomeArte(String nomeArte) {
		NomeArte = nomeArte;
	}
	public java.sql.Date getData() {
		return Data;
	}
	public void setData(java.sql.Date date) {
		Data = date;
	}
	public java.sql.Time getOrarioInizio() {
		return OrarioInizio;
	}
	public void setOrarioInizio(java.sql.Time orarioInizio) {
		OrarioInizio = orarioInizio;
	}
	public java.sql.Time getOrarioFine() {
		return OrarioFine;
	}
	public void setOrarioFine(java.sql.Time orarioFine) {
		OrarioFine = orarioFine;
	}
	public float getSupplemento() {
		return Supplemento;
	}
	public void setSupplemento(float supplemento) {
		Supplemento = supplemento;
	}
	public int getIdLocale() {
		return IdLocale;
	}
	public void setIdLocale(int idLocale) {
		IdLocale = idLocale;
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
	public String getGenereMusicale() {
		return GenereMusicale;
	}
	public void setGenereMusicale(String genereMusicale) {
		GenereMusicale = genereMusicale;
	}
	
}
