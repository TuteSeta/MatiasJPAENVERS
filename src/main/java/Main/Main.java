package Main;

import entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

           /* Factura factura1 = new Factura();
            factura1.setNumero(12);
            factura1.setFecha("10/08/2024");

            Domicilio dom = new Domicilio("Las Heras", 2847);
            Cliente cliente1 = new Cliente("Juan","Rodriguez",45867234);
            cliente1.setDomicilio(dom);
            dom.setCliente(cliente1);

            factura1.setCliente(cliente1);

            Categoria perecederos = new Categoria("perecederos");
            Categoria lacteos = new Categoria("lacteos");
            Categoria limpieza = new Categoria("Limpieza");

            Articulo art1 = new Articulo(200,"Yogurth de frutilla",20);
            Articulo art2 = new Articulo(100,"Detergente Magistral", 80);

            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            lacteos.getArticulos().add(art1);
            perecederos.getArticulos().add(art1);

            art2.getCategorias().add(limpieza);
            limpieza.getArticulos().add(art2);

            DetalleFactura detalle1 = new DetalleFactura();
            detalle1.setArticulo(art1);
            detalle1.setCantidad(2);
            detalle1.setSubtotal(40);

            art1.getDetalles().add(detalle1);
            factura1.getDetalles().add(detalle1);
            detalle1.setFactura(factura1);

            DetalleFactura detalle2 = new DetalleFactura();
            detalle2.setArticulo(art2);
            detalle2.setCantidad(1);
            detalle2.setSubtotal(80);

            art2.getDetalles().add(detalle2);
            factura1.getDetalles().add(detalle2);
            detalle2.setFactura(factura1);

            factura1.setTotal(120); */

            Factura factura1 = em.find(Factura.class, 1L);
            factura1.setNumero(85);

            em.merge(factura1);
            em.flush();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }

        em.close();
        emf.close();
    }
}