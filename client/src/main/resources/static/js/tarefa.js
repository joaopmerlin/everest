var app = new Vue({
    el: '#app',
    data: {
        tarefas: [],
        tarefasPendente: [],
        tarefasAndamento: [],
        tarefasFinalizado: [],
        tarefa: {}
    },
    methods: {

        getTarefas: function () {
            $.get("/tarefa/find").then(function (data) {
                app.tarefas = data;
                app.organizaTarefas();
            })
        },

        novo: function () {
            this.tarefa = {
                status: "PENDENTE"
            };
        },

        alterar: function (tarefa) {
            this.tarefa = tarefa;
            $("#myModal").modal("show");
        },

        salvar: function (tarefa, update) {
            $.post("/tarefa", JSON.stringify(tarefa)).then(function (data) {
                app.tarefa = data;
                app.getTarefas();
                if (!update) {
                    $("#myModal").modal("hide");
                    alertify.success('Cadastro salvo com sucesso');
                }
            }, function (e) {
                alertify.error(e.responseJSON.message);
            })
        },

        organizaTarefas: function () {
            var status = ['PENDENTE', 'ANDAMENTO', 'FINALIZADO'];
            status.forEach(function (st, i) {
                if (i === 0)
                    app.tarefasPendente = app.tarefas.filter(function (e) {
                        return e.status === st;
                    });
                else if (i === 1)
                    app.tarefasAndamento = app.tarefas.filter(function (e) {
                        return e.status === st;
                    });
                else
                    app.tarefasFinalizado= app.tarefas.filter(function (e) {
                        return e.status === st;
                    });
            });
        },

        updateStatus: function (e) {
            var tarefa;
            var status = $(e.target).data('status');
            if (status === 'PENDENTE')
                tarefa = app.tarefasPendente[e.newIndex];
            else if (status === 'ANDAMENTO')
                tarefa = app.tarefasAndamento[e.newIndex];
            else
                tarefa = app.tarefasFinalizado[e.newIndex];
            tarefa.status = status;
            app.salvar(tarefa, true);
        },

        largarTarefa: function (tarefa) {
            tarefa.userId = null;
            tarefa.status = 'PENDENTE';
            this.salvar(tarefa);
        }

    },
    mounted: function () {
        this.getTarefas();
    }
});