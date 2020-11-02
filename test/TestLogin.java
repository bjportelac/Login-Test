/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Control.ValidarLogin;
import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author benga
 */
public class TestLogin {
    
    private static ValidarLogin validarLogin = new ValidarLogin();
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta";
    private String DATOS_INCORRECTOS = "Datos Incorrectos";
    private String USUARIO_AUTORIZADO = "Bienvenido";
    
    public TestLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        //Array list de usuarios
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        
        // Creacion de usuarios
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        //Ajustes de atributos
        a.setNombre("Alex");
        a.setPassword("1234");
        b.setNombre("Camilo");
        b.setPassword("0000");
        c.setNombre("David");
        c.setPassword("9876");
        
        //Añadir usuarios al arraylist
        usuario.add(a);
        usuario.add(b);
        usuario.add(c);
        
        //añadir regisstro de usuarios en el sistema
        sistema.setUsuarios(usuario);
        
        //recorrer el arraylist de sistema
        for (Usuario u:sistema.getUsuarios()){
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("-----------------");
        }
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testLongitudNombre(){
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u),LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void testLongitudContrasena(){
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarLogin.verificarLogin(u),LONG_PASSWORD_INCORRECTA);
        
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u),LONG_PASSWORD_INCORRECTA);
    }
    
    @Test
    public void testNombre(){
        Usuario u = new Usuario();
        u.setNombre("Dana");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u),DATOS_INCORRECTOS);
    }
    
    @Test
    public void testContrasena(){
        Usuario u = new Usuario();
        u.setNombre("Camilo");
        u.setPassword("1111");
        assertEquals(validarLogin.verificarLogin(u),DATOS_INCORRECTOS);
    }
    
    @Test
    public void testDatos(){
        Usuario u = new Usuario();
        u.setNombre("Camila");
        u.setPassword("0000");
        assertEquals(validarLogin.verificarLogin(u),DATOS_INCORRECTOS);
    }
    
    @Test
    public void testTodoCorrecto(){
        Usuario u = new Usuario();
        u.setNombre("Alex");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u),USUARIO_AUTORIZADO);
        
        u.setNombre("Camilo");
        u.setPassword("0000");
        assertEquals(validarLogin.verificarLogin(u),USUARIO_AUTORIZADO);
        
        u.setNombre("David");
        u.setPassword("9876");
        assertEquals(validarLogin.verificarLogin(u),USUARIO_AUTORIZADO);
    }
    
    @After
    public void tearDown() {
    }

    
}
