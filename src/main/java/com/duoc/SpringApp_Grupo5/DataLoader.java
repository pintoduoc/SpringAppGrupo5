/*
package com.duoc.SpringApp_Grupo5;

import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Producto;
import com.duoc.SpringApp_Grupo5.Modelo.GestionInventario.Proveedor;
import com.duoc.SpringApp_Grupo5.Modelo.LogisticayEnvio.Envio;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Cliente;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Pedido;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Reporte;
import com.duoc.SpringApp_Grupo5.Modelo.ReportesyAnaliticas.Resena;
import com.duoc.SpringApp_Grupo5.Modelo.Usuarios.Usuario;
import com.duoc.SpringApp_Grupo5.Modelo.VentasFacturacion.Venta;
import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProductoRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.GestionInventario.ProveedorRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.LogisticayEnvio.EnvioRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ClienteRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.PedidoRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ReporteRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.ReportesyAnaliticas.ResenaRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.Usuarios.UsuarioRepository;
import com.duoc.SpringApp_Grupo5.Repositorio.VentasFacturacion.VentaRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private EnvioRepository envioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ReporteRepository reporteRepository;
    @Autowired
    private ResenaRepository resenaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        Random random = new Random();


        //Generar Proveedor
        for (int i = 0; i < 5; i++) {
            Proveedor proveedor = new Proveedor();
            proveedor.setContacto(faker.phoneNumber().cellPhone());
            proveedor.setDireccion(faker.address().fullAddress());
            proveedor.setNombre(faker.company().name());
            proveedorRepository.save(proveedor);
        }
        List<Proveedor> proveedores = proveedorRepository.findAll();

        //Generar Producto
        for (int i = 0; i < 5; i++) {
            Producto producto = new Producto();
            producto.setCategoria(faker.food().ingredient());
            producto.setDescripcion(faker.lorem().sentence());
            producto.setNombre(faker.food().dish());
            producto.setPrecio(random.nextInt(100));
            producto.setStock(random.nextInt(100));
            producto.setProveedor(proveedores.get(random.nextInt(proveedores.size())));
            productoRepository.save(producto);
        }
        List<Producto> productos = productoRepository.findAll();

        //Generar Cliente
        for (int i = 0; i < 5; i++) {
            Cliente cliente = new Cliente();
            cliente.setDireccionCliente(faker.address().fullAddress());
            cliente.setEmailCliente(faker.internet().emailAddress());
            cliente.setNombreCliente(faker.name().fullName());
            cliente.setPasswordCliente(faker.eldenRing().npc());
            clienteRepository.save(cliente);
        }
        List<Cliente> clientes = clienteRepository.findAll();

        //Generar Pedido
        for (int i = 0; i < 5; i++) {
            Pedido pedido = new Pedido();
            pedido.setEstado(faker.animal().name());
            pedido.setCliente(clientes.get(random.nextInt(clientes.size())));
            pedidoRepository.save(pedido);
        }
        List<Pedido> pedidos = pedidoRepository.findAll();

        //Generar Envio
        for (int i = 0; i < 5; i++) {
            Envio envio = new Envio();
            envio.setDireccionEnvio(faker.address().fullAddress());
            envio.setEstadoEnvio(faker.animal().name());
            envio.setFechaEnvio(faker.business().creditCardExpiry());
            envio.setCliente(clientes.get(random.nextInt(clientes.size())));
            envio.setPedido(pedidos.get(random.nextInt(pedidos.size())));
            envioRepository.save(envio);
        }

        //Generar Reporte
        for (int i = 0; i < 5; i++) {
            Reporte reporte = new Reporte();
            reporte.setDatos(faker.lorem().sentence());
            reporte.setFechaGeneracion(new Date(System.currentTimeMillis()));
            reporte.setTipo(faker.company().buzzword());
            reporteRepository.save(reporte);
        }

        //Generar Reseña
        for (int i = 0; i < 5; i++) {
            Resena resena = new Resena();
            resena.setCalificacion(faker.number().numberBetween(1, 10));
            resena.setComentario(faker.lorem().sentence());
            resena.setCliente(clientes.get(random.nextInt(clientes.size())));
            resena.setProducto(productos.get(random.nextInt(productos.size())));
            resenaRepository.save(resena);
        }
        //Generar Usuario
        for (int i = 0; i < 5; i++) {
            Usuario usuario = new Usuario();
            usuario.setContrasena(faker.eldenRing().skill());
            usuario.setEmail(faker.internet().emailAddress());
            usuario.setEstado(faker.bool().bool());
            usuario.setNombre(faker.name().fullName());
            usuario.setRol(faker.company().profession());
            usuarioRepository.save(usuario);
        }
        List<Usuario> usuarios = usuarioRepository.findAll();
        //Generar Venta
        for (int i = 0; i < 5; i++) {
            Venta venta = new Venta();
            venta.setUsuario(usuarios.get(random.nextInt(usuarios.size())));
            List<Producto> productosVenta = new ArrayList<>();
            for (int j = 0; j < random.nextInt(3) + 1; j++) {
                productosVenta.add(productos.get(random.nextInt(productos.size())));
            }
            venta.setProductosVenta(productosVenta);
            ventaRepository.save(venta);
        }


    }

}
*/