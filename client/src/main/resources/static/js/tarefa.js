new Vue({
    el: '#app',
    data: {
        tarefas: [],
        tarefa: {}
    },
    methods: {

        getTarefas: function () {
            $.get("/tarefa/find").then(function (data) {
                app.tarefas = data;
            })
        },

        novo: function () {
            this.tarefa = {
                status: "PENDENTE"
            };
        },

        alterar: function (user) {
            this.tarefa = user;
        },

        salvar: function (user) {
            $.post("/tarefa", JSON.stringify(user)).then(function (data) {
                app.tarefa = data;
                app.getTarefas();
                $("#myModal").modal("hide");
                alertify.success('Cadastro salvo com sucesso');
            }, function (e) {
                alertify.error(e.responseJSON.message);
            })
        }

    },
    mounted: function () {
        this.getTarefas();
    }
});