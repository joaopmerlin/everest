var app = new Vue({
    el: '#app',
    data: {
        usuarios: [],
        usuario: {}
    },
    methods: {

        getUsers: function () {
            $.get("/usuario/find").then(function (data) {
                app.usuarios = data;
            })
        },

        novo: function () {
            this.usuario = {};
        },

        alterar: function (user) {
            this.usuario = user;
        },

        salvar: function (user) {
            $.post("/usuario", JSON.stringify(user)).then(function (data) {
                app.usuario = data;
                app.getUsers();
                $("#myModal").modal("hide");
                alertify.success('Cadastro salvo com sucesso');
            }, function (e) {
                alertify.error(e.responseJSON.message);
            })
        },

        remover: function (user) {
            alertify.confirm('Confirmação', 'Remover este cadastro?', function () {
                $.post("/usuario/remove", JSON.stringify(user)).then(function () {
                    app.getUsers();
                    alertify.success('Cadastro removido com sucesso');
                }, function (e) {
                    alertify.error(e.responseJSON.message);
                });
            }, function () {});
        }

    },
    mounted: function () {
        this.getUsers();
    }
});