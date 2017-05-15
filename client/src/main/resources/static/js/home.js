var app = new Vue({
    el: '#app',
    data: {
        tarefas: [],
        ultimasTarefas: []
    },
    methods: {

        getTarefas: function () {
            $.get("/tarefa/find").then(function (data) {
                app.tarefas = data;
                app.montaChartStatus();
            })
        },

        tarefasNaoAtribuidas: function () {
            return this.tarefas.filter(function (e) {
                return !e.userId;
            }).length;
        },

        tarefasAFazer: function () {
            return this.tarefas.filter(function (e) {
                return e.userId === user.id && e.status === 'PENDENTE';
            }).length;
        },

        tarefasEmAndamento: function () {
            return this.tarefas.filter(function (e) {
                return e.userId === user.id && e.status === 'ANDAMENTO';
            }).length;
        },

        tarefasFinalizadas: function () {
            return this.tarefas.filter(function (e) {
                return e.userId === user.id && e.status === 'FINALIZADO';
            }).length;
        },

        montaChartStatus: function () {
            var ctx = $("#chartStatus");
            var data = {
                labels: ["A fazer", "Em andamento", "Finalizadas"],
                datasets: [
                    {
                        data: [app.tarefasAFazer(), app.tarefasEmAndamento(), app.tarefasFinalizadas()],
                        backgroundColor: [
                            "#5cb85c",
                            "#f0ad4e",
                            "#d9534f"
                        ],
                        hoverBackgroundColor: [
                            "#5cb85c",
                            "#f0ad4e",
                            "#d9534f"
                        ]
                    }
                ]
            };
            new Chart(ctx, {type: 'doughnut', data: data});
        },

        getUltimasTarefas: function () {
            $.get("/tarefa/last").then(function (data) {
                app.ultimasTarefas = data;
            })
        }

    },
    mounted: function () {
        this.getTarefas();
        this.getUltimasTarefas();
    }
});