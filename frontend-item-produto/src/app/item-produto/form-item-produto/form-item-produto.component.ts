import { MessageToastService } from './../../shared/service/message-toast.service';
import { Produto } from './../../shared/entity/produto';
import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../../shared/service/produto.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-form-item-produto',
  templateUrl: './form-item-produto.component.html',
  styleUrls: ['./form-item-produto.component.css']
})
export class FormItemProdutoComponent implements OnInit {

  produtos: any

  constructor(private produtoService: ProdutoService, 
    private messageToastService: MessageToastService
  ) { }

  ngOnInit() {
    this.buscar()    
  }
  
  buscar(){
    this.produtoService.getProdutos()
    .subscribe(produto => this.produtos = produto)
  }

  buscarPorId(frm: FormControl){
    this.produtoService.getProdutosPorId(frm.value)
    .subscribe(produto => this.produtos = produto)
  }

  adicionar(frm: FormControl){
    this.produtoService.postProdutos(frm.value)
    .subscribe(produto => {
      this.produtos = produto
      this.messageToastService.mensagemSuccess('O Produto foi cadastrado com sucesso!', 'Cadastrar Produto', 3000)
      frm.reset()
      location.reload()
    })
  }

  salvar(frm: FormControl){
    if(frm.value.id){
      this.atualizar(frm)
    }else{
      this.adicionar(frm)
    }
  }

  atualizar(frm: FormControl){
    this.produtoService.putProduto(frm.value)
    .subscribe(produto => {
      this.produtos = produto
      this.messageToastService.mensagemSuccess('O Produto atualizado com sucesso!', 'Atualizar Produto', 3000)
      frm.reset()
      location.reload()
    })
  }  
}