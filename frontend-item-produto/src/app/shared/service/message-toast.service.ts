import { MessageService } from 'primeng/api';
import { Injectable } from '@angular/core';

@Injectable()
export class MessageToastService {

  constructor(private messageService: MessageService) { }

  /**
   * @param severity Tipo da mensagem devido sua prioridade `success` `info` `warn` `error`.
   * @param summary Titulo da caixa de mensagem.
   * @param detail Mensagem no corpo da caixa de mensagem.
   * @param life Tempo que a caixa de mensagem fica sendo exibida.
   */

  entregaMensagem = (tipoMensagem: string, mensagem: string, titulo: string, tempoExibicao: number) => {
    const messageServicePorperties = {
      severity: tipoMensagem,
      summary: mensagem,
      detail: titulo,
      life: tempoExibicao
    }
    this.messageService.add(messageServicePorperties)
  }

  mensagemSuccess(mensagem: string, titulo: string, tempoExibicao: number) {
    return this.entregaMensagem('success', mensagem, titulo, tempoExibicao)
  }

  mensagemInfo(mensagem: string, titulo: string, tempoExibicao: number) {
    return this.entregaMensagem('info', mensagem, titulo, tempoExibicao)
  }

  mensagemErro(mensagem: string, titulo: string, tempoExibicao: number) {
    return this.entregaMensagem('error', mensagem, titulo, tempoExibicao)
  }

  mensagemAviso(mensagem: string, titulo: string, tempoExibicao: number) {
    return this.entregaMensagem('warn', mensagem, titulo, tempoExibicao)
  }

  msgConfirm(tipoMensagem: string, mensagem: string, titulo: string, tempoExibicao: number) {
    return this.entregaMensagem(tipoMensagem, mensagem, titulo, tempoExibicao)
  }

}
