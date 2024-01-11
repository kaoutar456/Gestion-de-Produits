package com.examen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }

    public void createProduit(Produit produit) {
   
        if (produitExiste(produit.getId()) || produitExiste(produit.getNom())) {
            throw new IllegalArgumentException("Un produit avec le même ID ou nom existe déjà.");
        }

    
        if (produit.getPrix() <= 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
        }

       
        produits.add(produit);
    }

   

    public void deleteProduit(Long id) {
        Iterator<Produit> iterator = produits.iterator();
        while (iterator.hasNext()) {
            Produit produit = iterator.next();
            if (produit.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }

     
        throw new IllegalArgumentException("Produit non trouvé avec l'ID : " + id);
    }

  
    private boolean produitExiste(Long id) {
        return produits.stream().anyMatch(produit -> produit.getId().equals(id));
    }

    private boolean produitExiste(String nom) {
        return produits.stream().anyMatch(produit -> produit.getNom().equals(nom));
    }


}
