package pe.isil.moduloseguridadep1;

import javax.persistence.*;

@Entity
@Table (name = "tbl_celular")
public class celular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Marca", nullable = false)
    private String marca;

    @Column(name = "Modelo", nullable = false, unique = true)
    private String modelo;

    @Column(name = "SistemaOperativo", nullable = false)
    private String sisope;
}
