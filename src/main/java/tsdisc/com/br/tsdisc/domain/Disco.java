package tsdisc.com.br.tsdisc.domain;

public class Disco {
    private Long id;
    private String nome;
    private double nota;

    public Disco(long id, String nome, double nota){
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
