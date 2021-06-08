/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eventos.ifms.controller;

/**
 *
 * @author davia
 */

import edu.eventos.ifms.model.areaModel;
import edu.eventos.ifms.model.servidorModel;
import edu.eventos.ifms.repository.areaRepository;
import edu.eventos.ifms.repository.servidorRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;


@ManagedBean
@ViewScoped


public class areaController {
    
    private areaModel areaModel;
    private areaRepository areaRepository;
    private servidorRepository servidorRepository;
    private List<areaModel> listaDeArea;
    
    public areaController() {
        this.areaModel = new areaModel();
        this.servidorRepository = new servidorRepository();
        this.areaRepository = new areaRepository();
        this.listaDeArea = new ArrayList<>();
    }

    public void salvar(){
        this.areaRepository.salvar(this.areaModel);
    }

    public String salvarEdicao() {
        this.areaRepository.salvar(this.areaModel);
        return "buscarArea.xhtml?faces-redirect=true";
    }
    
    public void remover(long idArea) {
        this.areaRepository.remover(idArea);
    }
    
    public String editar(long idArea) {
        return "editarArea.xhtml?faces-redirect=true&idServidor=" + idArea;
    }
    
    public void buscarArea() {
        this.areaModel = this.areaRepository.buscarPorId(this.areaModel.getIdArea());
    }
    
    
    public List<SelectItem> getAreas() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<areaModel> listaDeAreas = this.areaRepository.buscar();
        for (areaModel area : listaDeAreas) {
            itens.add(new SelectItem(area.getIdArea(), area.getAreaNome()));
        }
        return itens;
    }

    public List<SelectItem> getServidores() {
        ArrayList<SelectItem> itens = new ArrayList<SelectItem>();
        List<servidorModel> listaDeServidores = this.servidorRepository.buscarTodos();
        for (servidorModel servidor : listaDeServidores) {
            itens.add(new SelectItem(servidor.getIdPessoa(), servidor.getPessoaNome()));
        }
        return itens;
    }

    
     public void buscarTodasAreas() {
        this.listaDeArea = this.areaRepository.buscarTodos();
    }
     
     public areaModel getAreaModel() {
        return areaModel;
    }
     
     public void setAreaModel(areaModel areaModel) {
        this.areaModel = areaModel;
    }
     
      public areaRepository getAreaRepository() {
        return areaRepository;
    }
      
      public void setAreaRepository(areaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
      
        public servidorRepository getServidorRepository() {
        return servidorRepository;
    }
        
        public void setServidorRepository(servidorRepository servidorRepository) {
        this.servidorRepository = servidorRepository;
    }
        
        public List<areaModel> getListaDeArea() {
        return listaDeArea;
    }
        
         public void setListaDeArea(List<areaModel> listaDeArea) {
        this.listaDeArea = listaDeArea;
    }
}

