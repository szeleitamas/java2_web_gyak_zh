package com.example.web2;

class OprendszerekNotFoundException extends RuntimeException {
    OprendszerekNotFoundException(Long id) {
        super("A szoftver nem található: " +id);
    }
}