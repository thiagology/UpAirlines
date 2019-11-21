
package projetoUp.model;

/**
 *
 *
 */
public class Endereco {
    private String cidade;
    private String estado;
    private String pais;
    int cep;

    public Endereco(String cidade, String estado, String pais, int cep)
{
    this.cidade = cidade;
    this.estado = estado;
    this.pais = pais;
    this.cep = cep;
}
    
    public Endereco()
    {
        
    }
    
    public String getCidade() {
        return cidade;
    }

   
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

  
    public String getEstado() {
        return estado;
    }

   
    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
