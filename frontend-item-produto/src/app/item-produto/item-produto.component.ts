import { MessageToastService } from './../shared/service/message-toast.service';
import { ProdutoService } from './../shared/service/produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../shared/entity/produto';

import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-item-produto',
  templateUrl: './item-produto.component.html',
  styleUrls: ['./item-produto.component.css']
})
export class ItemProdutoComponent implements OnInit {

  produtos: any

  constructor(private produtoService: ProdutoService, 
    private messageService: MessageService,
    private messageToastService: MessageToastService
  ) { }

  ngOnInit() {
    this.listarProdutos()  
  }

  listarProdutos(){
    this.produtoService.getProdutos()
    .subscribe(dados => this.produtos = dados)
  }

  remover(produto){
    if (confirm('Deseja remover o produto ' + produto.nomeProduto + '?')) {	
      const index = this.produtos.indexOf(produto)
      this.produtos.splice(index, 1)      
      this.produtoService.deleteProdutos(produto.id)          
        .subscribe(() => {	
            this.messageToastService.msgRemoverProdutoErro()
            this.produtos.splice(index, 0, produto)
          }
        )
      this.messageToastService.msgRemoverProduto()
    }
  }  
}