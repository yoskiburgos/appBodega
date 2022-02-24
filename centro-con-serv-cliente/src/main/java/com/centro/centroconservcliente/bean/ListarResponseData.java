package com.centro.centroconservcliente.bean;

import java.util.List;

import lombok.Data;

@Data
public class ListarResponseData {
    private List<Cliente> clientes;
}
