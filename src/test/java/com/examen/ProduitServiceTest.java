package com.examen;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProduitServiceTest {

    private ProduitService produitService;

    @BeforeEach
    public void setUp() {
        produitService = new ProduitService();
    }

    @Test
    public void testCreateProduit() {
        Produit produit = new Produit(1L, "ProduitTest", 10.0, 5);

        produitService.createProduit(produit);

        Produit retrievedProduit = produitService.readProduit(1L);

        assertEquals(produit, retrievedProduit);
    }

    @Test
    public void testReadProduit() {
        Produit produit = new Produit(1L, "ProduitTest", 10.0, 5);
        produitService.createProduit(produit);

        Produit retrievedProduit = produitService.readProduit(1L);

        assertEquals(produit, retrievedProduit);
    }

    @Test
    public void testUpdateProduit() {
        Produit produit = new Produit(1L, "ProduitTest", 10.0, 5);
        produitService.createProduit(produit);

        Produit updatedProduit = new Produit(1L, "ProduitModifié", 15.0, 8);
        produitService.updateProduit(1L, updatedProduit);

        Produit retrievedProduit = produitService.readProduit(1L);

        assertEquals(updatedProduit, retrievedProduit);
    }

    @Test
    public void testDeleteProduit() {
        Produit produit = new Produit(1L, "ProduitTest", 10.0, 5);
        produitService.createProduit(produit);

        produitService.deleteProduit(1L);

        assertThrows(IllegalArgumentException.class, () -> produitService.readProduit(1L));
    }

    @Test
    public void testCreateProduitWithSameId() {
        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        Produit produit2 = new Produit(1L, "Produit2", 15.0, 8);

        produitService.createProduit(produit1);

        assertThrows(IllegalArgumentException.class, () -> produitService.createProduit(produit2));
    }

    @Test
    public void testCreateProduitWithSameNom() {
        Produit produit1 = new Produit(1L, "Produit1", 10.0, 5);
        Produit produit2 = new Produit(2L, "Produit1", 15.0, 8);

        produitService.createProduit(produit1);

        assertThrows(IllegalArgumentException.class, () -> produitService.createProduit(produit2));
    }

    @Test
    public void testCreateProduitWithNegativePrice() {
        Produit produit = new Produit(1L, "ProduitTest", -10.0, 5);

        assertThrows(IllegalArgumentException.class, () -> produitService.createProduit(produit));
    }

    @Test
    public void testCreateProduitWithNegativeQuantity() {
        Produit produit = new Produit(1L, "ProduitTest", 10.0, -5);

        assertThrows(IllegalArgumentException.class, () -> produitService.createProduit(produit));
    }
}