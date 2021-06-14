import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

public class Controller {

	private DBconnection dataSource;
    
    public Controller() {
        dataSource = new DBconnection();
    }
    
    int countClienti=0;
    public List<Dipendente> findAllDipendenti()  {
        List<Dipendente> dipendenti = null;
        Dipendente dipendente = null;
        Connection connection = this.dataSource.getMySQLConnection();
        PreparedStatement statement = null;
        String query = "select * from dipendente" ;
        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                dipendenti = new LinkedList<Dipendente>();
                dipendente = new Dipendente();
                dipendente.setCF(result.getString("cf"));
                dipendente.setNome(result.getString("nome"));
                dipendente.setCognome(result.getString("cognome"));
                dipendente.setResidenza(result.getString("residenza"));
                Date date = Date.valueOf(result.getString("DataNascita"));
                dipendente.setDataNascita(date);
                dipendente.setTelefono(result.getString("Telefono"));
                dipendente.setMansione(result.getString("mansione"));
                dipendente.setIdBar(result.getInt("IdBar"));
                dipendente.setIdLocale(result.getInt("IdLocale"));
                
                dipendenti.add(dipendente);
            }
            
            while(result.next()) {
            	dipendente = new Dipendente();
                dipendente.setCF(result.getString("cf"));
                dipendente.setNome(result.getString("nome"));
                dipendente.setCognome(result.getString("cognome"));
                dipendente.setResidenza(result.getString("residenza"));
                Date date = Date.valueOf(result.getString("DataNascita"));
                dipendente.setDataNascita(date);
                dipendente.setTelefono(result.getString("Telefono"));
                dipendente.setMansione(result.getString("mansione"));
                dipendente.setIdBar(result.getInt("IdBar"));
                dipendente.setIdLocale(result.getInt("IdLocale"));
                
                dipendenti.add(dipendente);
            }
        }
        catch (SQLException e) {
        	new Exception(e.getMessage());
            System.out.println("Errore"+ e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	new Exception(e.getMessage());
	             System.out.println("Errore"+ e.getMessage());
            }
        }
        return dipendenti;
    }   
    
    public List<Cliente> findAllClienti()  {
        List<Cliente> clienti = null;
        Cliente cliente = null;
        Connection connection = this.dataSource.getMySQLConnection();
        PreparedStatement statement = null;
        String query = "select * from Cliente";
        countClienti=0;
        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                clienti = new LinkedList<Cliente>();
                cliente = new Cliente();
                cliente.setCF(result.getString("cf"));
                cliente.setNome(result.getString("nome"));
                cliente.setCognome(result.getString("cognome"));
                cliente.setDataNascita(new java.util.Date(result.getDate("dataNascita").getTime()));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefono(result.getString("telefono"));
                cliente.setIdLocale(result.getInt("IdLocale"));
                
                clienti.add(cliente);
            }
            
            while(result.next()) {
            	cliente = new Cliente();
            	cliente.setCF(result.getString("cf"));
                cliente.setNome(result.getString("nome"));
                cliente.setCognome(result.getString("cognome"));
                cliente.setDataNascita(new java.util.Date(result.getDate("dataNascita").getTime()));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefono(result.getString("telefono"));
                cliente.setIdLocale(result.getInt("IdLocale"));
                countClienti++;
                clienti.add(cliente);
            }
        }
        catch (SQLException e) {
        	new Exception(e.getMessage());
            System.out.println("Errore"+ e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	new Exception(e.getMessage());
	             System.out.println("Errore"+ e.getMessage());
            }
        }
        
        return clienti;
    }   
    
    public List<Sala> findAllSale()  {
        List<Sala> sale = null;
        Sala sala = null;
        Connection connection = this.dataSource.getMySQLConnection();
        PreparedStatement statement = null;
        String query = "select * from Sala";
        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                sale = new LinkedList<Sala>();
                sala = new Sala();
                
                sala.setIdSala(result.getInt("IdSala"));
                sala.setTipoMusica(result.getString("TipoMusica"));
                sala.setCapienza(result.getInt("Capienza"));
                sala.setIdLocale(result.getInt("IdLocale"));
                            
                sale.add(sala);
            }
            
            while(result.next()) {
            	sala = new Sala();
                
                sala.setIdSala(result.getInt("IdSala"));
                sala.setTipoMusica(result.getString("TipoMusica"));
                sala.setCapienza(result.getInt("Capienza"));
                sala.setIdLocale(result.getInt("IdLocale"));
                            
                sale.add(sala);
            }
        }
        catch (SQLException e) {
        	new Exception(e.getMessage());
            System.out.println("Errore"+ e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	new Exception(e.getMessage());
	             System.out.println("Errore"+ e.getMessage());
            }
        }
        return sale;
    }   
    
    public void insertDipendente(Dipendente dipendente) {
       Connection connection = this.dataSource.getMySQLConnection();
     
        PreparedStatement statement = null; 
        String insert = "insert into Dipendente (CF, Nome, Cognome, Residenza, DataNascita, Telefono, Mansione, IdBar, IdLocale) values (?,?,?,?,?,?,?,?,?)";
        try {
              	
            statement = connection.prepareStatement(insert);
            
            statement.setString(1, dipendente.getCF());
            statement.setString(2, dipendente.getNome());
            statement.setString(3, dipendente.getCognome());
            statement.setString(4, dipendente.getResidenza());
            statement.setDate(5, new java.sql.Date(dipendente.getDataNascita().getTime()));
            statement.setString(6, dipendente.getTelefono());
            statement.setString(7, dipendente.getMansione());
            statement.setInt(8, dipendente.getIdBar());
            statement.setInt(9, dipendente.getIdLocale());



            statement.executeUpdate();
        }
        catch (SQLException e) {
           	new Exception(e.getMessage());
            System.out.println("Errore"+ e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            }
            catch (SQLException e) {
            	new Exception(e.getMessage());
	            System.out.println("Errore"+ e.getMessage());
            }
        }
    }
    
    public void insertCliente(Cliente cliente) {
        Connection connection = this.dataSource.getMySQLConnection();
      
         PreparedStatement statement = null; 
         String insert = "insert into Cliente (CF, Nome, Cognome, DataNascita, Email, Telefono, IdLocale) values (?,?,?,?,?,?,?)";
         try {
               	
             statement = connection.prepareStatement(insert);
             
             statement.setString(1, cliente.getCF());
             statement.setString(2, cliente.getNome());
             statement.setString(3, cliente.getCognome());
             statement.setDate(4, new java.sql.Date(cliente.getDataNascita().getTime()));
             statement.setString(5, cliente.getEmail());
             statement.setString(6, cliente.getTelefono());
             statement.setInt(7, cliente.getIdLocale());

             statement.executeUpdate();
         }
         catch (SQLException e) {
            	new Exception(e.getMessage());
             System.out.println("Errore"+ e.getMessage());
         }
         finally {
             try {
                 if (statement != null) 
                     statement.close();
                 if (connection!= null)
                     connection.close();
             }
             catch (SQLException e) {
             	new Exception(e.getMessage());
 	            System.out.println("Errore"+ e.getMessage());
             }
         }
     }

	public List<Bar> findAllBar() {
		List<Bar> bars = null;
        Bar bar = null;
        Connection connection = this.dataSource.getMySQLConnection();
        PreparedStatement statement = null;
        String query = "select * from Bar";
        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                bars = new LinkedList<Bar>();
                bar = new Bar();
                
                bar.setIdBar(result.getInt("IdBar"));
                bar.setIdSala(result.getInt("IdSala"));
                            
                bars.add(bar);
            }
            
            while(result.next()) {
            	bar = new Bar();
                
                bar.setIdBar(result.getInt("IdBar"));
                bar.setIdSala(result.getInt("IdSala"));
                            
                bars.add(bar);
            }
        }
        catch (SQLException e) {
        	new Exception(e.getMessage());
            System.out.println("Errore"+ e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	new Exception(e.getMessage());
	             System.out.println("Errore"+ e.getMessage());
            }
        }
        return bars;
	}
    
	public List<Evento> findAllEventi()  {
        List<Evento> eventi = null;
        Evento evento = null;
        Connection connection = this.dataSource.getMySQLConnection();
        PreparedStatement statement = null;
        String query = "select c.NomeArte, Data, OrarioInizio, OrarioFine, Supplemento, Nome, Cognome, GenereMusicale, IdLocale from Concerto C Join Ospite O ON C.NomeArte=O.NomeArte";
        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if(result.next()) {
                eventi = new LinkedList<Evento>();
                evento = new Evento();
                
                evento.setNomeArte(result.getString("NomeArte"));
                evento.setData(new java.sql.Date(result.getDate("Data").getTime()));
                evento.setOrarioInizio(new java.sql.Time(result.getTime("OrarioInizio").getTime()));
                evento.setOrarioFine(new java.sql.Time(result.getTime("OrarioFine").getTime()));
                evento.setNome(result.getString("Nome"));
                evento.setCognome(result.getString("Cognome"));
                evento.setGenereMusicale(result.getString("GenereMusicale"));
                evento.setSupplemento(result.getFloat("Supplemento"));
                evento.setIdLocale(result.getInt("IdLocale"));
                           
                eventi.add(evento);
            }
            
            while(result.next()) {
            	evento = new Evento();
                
                evento.setNomeArte(result.getString("NomeArte"));
                evento.setData(new java.sql.Date(result.getDate("Data").getTime()));
                evento.setOrarioInizio(new java.sql.Time(result.getTime("OrarioInizio").getTime()));
                evento.setOrarioFine(new java.sql.Time(result.getTime("OrarioFine").getTime()));
                evento.setNome(result.getString("Nome"));
                evento.setCognome(result.getString("Cognome"));
                evento.setGenereMusicale(result.getString("GenereMusicale"));
                evento.setSupplemento(result.getFloat("Supplemento"));
                evento.setIdLocale(result.getInt("IdLocale"));
                           
                eventi.add(evento);
            }
        }
        catch (SQLException e) {
        	new Exception(e.getMessage());
            System.out.println("Errore"+ e.getMessage());
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	new Exception(e.getMessage());
	             System.out.println("Errore"+ e.getMessage());
            }
        }
        return eventi;
    }   
	
	public void insertConcerto(Evento evento) {
        Connection connection = this.dataSource.getMySQLConnection();
      
         PreparedStatement statement = null; 
         String insert = "insert into Concerto (NomeArte, Data, OrarioInizio, OrarioFine, Supplemento, IdLocale) values (?,?,?,?,?,?)";
         try {
               	
             statement = connection.prepareStatement(insert);
             
             statement.setString(1, evento.getNomeArte());
             statement.setDate(2, new java.sql.Date(evento.getData().getTime()));
             statement.setTime(3, new java.sql.Time(evento.getOrarioInizio().getTime()));
             statement.setTime(4, new java.sql.Time(evento.getOrarioFine().getTime()));
             statement.setFloat(5, evento.getSupplemento());
             statement.setInt(6, evento.getIdLocale());

             statement.executeUpdate();
         }
         catch (SQLException e) {
            	new Exception(e.getMessage());
             System.out.println("Errore"+ e.getMessage());
         }
         finally {
             try {
                 if (statement != null) 
                     statement.close();
                 if (connection!= null)
                     connection.close();
             }
             catch (SQLException e) {
             	new Exception(e.getMessage());
 	            System.out.println("Errore"+ e.getMessage());
             }
         }
     }
	
	public void insertOspite(Evento evento) {
        Connection connection = this.dataSource.getMySQLConnection();
      
         PreparedStatement statement = null; 
         String insert = "insert into Ospite (NomeArte, Nome, Cognome, GenereMusicale) values (?,?,?,?)";
         try {
               	
             statement = connection.prepareStatement(insert);
             
             statement.setString(1, evento.getNomeArte());
             statement.setString(2, evento.getNome());
             statement.setString(3,  evento.getCognome());
             statement.setString(4, evento.getGenereMusicale());

             statement.executeUpdate();
         }
         catch (SQLException e) {
            	new Exception(e.getMessage());
             System.out.println("Errore"+ e.getMessage());
         }
         finally {
             try {
                 if (statement != null) 
                     statement.close();
                 if (connection!= null)
                     connection.close();
             }
             catch (SQLException e) {
             	new Exception(e.getMessage());
 	            System.out.println("Errore"+ e.getMessage());
             }
         }
     }    
	
	public int countClienti() {
		return countClienti+1;
	}
}
