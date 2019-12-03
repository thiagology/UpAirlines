
package projetoUp.model;



public class Assento{
    private String id;
    private boolean ocupado;
    
    public Assento()
    {
    	this.ocupado = false;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    public String getId()
    {
        return this.id;
    }
    public void reservar()
    {
        this.ocupado = true;
    }
    public void cancelarReserva()
    {
        if(this.ocupado == true);
        {
            this.ocupado = false;
        }
    }
    
    public boolean getOcupado()
    {
    	return this.ocupado;
    }
    
    public boolean equals(Assento assento)
    {
    	if(this.id.equals(assento.id))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
}
