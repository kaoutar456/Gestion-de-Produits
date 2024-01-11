package com.examen;

public class Produit {
    private Long id;
    private String nom;
    private double prix;
    private int quantite;

    public Produit(Long id, String nom, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


     
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Produit produit = (Produit) obj;
        return id.equals(produit.id) && nom.equals(produit.nom) && Double.compare(produit.prix, prix) == 0 && quantite == produit.quantite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prix, quantite);
    }

    @Override
    public String toString() {
        return "Produit{id=" + id + ", nom='" + nom + "', prix=" + prix + ", quantite=" + quantite + '}';
    }
}
