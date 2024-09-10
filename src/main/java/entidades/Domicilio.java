package entidades;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Domicilio")
@Getter
@Setter
@Audited
public class Domicilio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombrecalle")
    private String nombrecalle;
    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

    public Domicilio() {
    }

    public Domicilio(String nombrecalle, int numero) {
        this.nombrecalle = nombrecalle;
        this.numero = numero;
    }

    public Domicilio(String nombrecalle, int numero, Cliente cliente) {
        this.nombrecalle = nombrecalle;
        this.numero = numero;
        this.cliente = cliente;
    }
}