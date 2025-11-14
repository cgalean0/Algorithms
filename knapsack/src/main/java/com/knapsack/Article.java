package com.knapsack;
public class Article implements Comparable<Article>{
        private String name;
        private int weight;
        private int value;

        public Article(String name, int weight, int value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        public int getWeigth() { return weight; }
        public int getValue() { return value; }
        public String getName() { return name; }

        @Override
        public int compareTo(Article o) {
            if (this.value < o.getValue())
                return -1;
            else if (this.value > o.getValue())
                return 1;
            else
                return 0;
        }

        @Override
        public boolean equals(Object obj) {
            
            // Paso 1: Optimización de referencia
            if (this == obj) {
                return true;
            }

            // Paso 2: Chequeo de tipo y nulidad (instanceof maneja el null)
            if (!(obj instanceof Article)) {
                return false;
            }

            // Paso 3: Casteo (seguro gracias al instanceof)
            Article otroArticle = (Article) obj;

            // Paso 4: Comparación de campos significativos
            // (Usamos Objects.equals() para manejar 'nombre' nulo de forma segura)
            // (Usamos == para el primitivo 'id')
            
            return this.name == otroArticle.getName() &&
                   java.util.Objects.equals(this.name, otroArticle.name);
        }
    }