import { MessageToastService } from './../shared/service/message-toast.service';
import { ProdutoService } from './../shared/service/produto.service';
import { Component, OnInit } from '@angular/core';
import { Produto } from '../shared/entity/produto';

@Component({
  selector: 'app-item-produto',
  templateUrl: './item-produto.component.html',
  styleUrls: ['./item-produto.component.css']
})
export class ItemProdutoComponent implements OnInit {

  produtos: any

  constructor(private produtoService: ProdutoService,
    private messageToastService: MessageToastService
  ) { }

  ngOnInit() {
    this.listarProdutos()
  }

  listarProdutos(){
    this.produtoService.getProdutos()
    .subscribe(produto => this.produtos = produto)
  }

  remover(produto){
    if (confirm('Deseja remover o produto ' + produto.nomeProduto + '?')) {	
      const index = this.produtos.indexOf(produto)
      this.produtos.splice(index, 1)      
      this.produtoService.deleteProdutos(produto.id)          
        .subscribe(() => {	
            this.messageToastService.mensagemSuccess('O Produto foi cadastrado com sucesso!', 'Cadastrar Produto', 3000)
            this.produtos.splice(index, 0, produto)
          }
        )
      this.messageToastService.mensagemInfo('O Produto foi removido com sucesso!', 'Remover Produto', 3000)
    }
  }  
}