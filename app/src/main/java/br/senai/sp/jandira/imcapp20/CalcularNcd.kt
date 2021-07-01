package br.senai.sp.jandira.imcapp20

fun calcularNcd(idade: Int , peso:Double, nivelDeAtividade: Int, genero:Char ) : Double {

    var ncd = 0.0;

    if (genero == 'm') {
        if (nivelDeAtividade == 0) {
            if (idade == 1) {
                ncd = 15.3 * peso + 679;
            } else if (idade == 2) {
               ncd = 11.6 * peso + 879;
            } else {
                ncd = 13.5 * peso + 487;
            }

        } else
            if (nivelDeAtividade == 1) {
                if (idade == 1) {
                   ncd = (15.3 * peso + 679) * 1.5;
                } else if (idade == 2) {
                    ncd =  (11.6 * peso + 879) * 1.5;
                } else {
                    ncd = (13.5 * peso + 487) * 1.5;
                }

            } else
                if (nivelDeAtividade == 2) {
                    if (idade == 1) {
                        ncd = (15.3 * peso + 679) * 1.8;
                    } else if (idade == 2) {
                        ncd =  (11.6 * peso + 879) * 1.8;
                    } else {
                        ncd = (13.5 * peso + 487) * 1.8;
                    }

                } else
                    if (nivelDeAtividade == 3) {
                        if (idade == 1) {
                            ncd =  (15.3 * peso + 679) * 2.1;
                        } else if (idade == 2) {
                            ncd = (11.6 * peso + 879) * 2.1;
                        } else {
                            ncd = (13.5 * peso + 487) * 2.1;
                        }
                    }
    } else
        if (genero == 'f') {
            if (nivelDeAtividade == 0) {
                if (idade == 1) {
                    ncd = 15.3 * peso + 679;
                } else if (idade == 2) {
                    ncd = 11.6 * peso + 879;
                } else {
                    ncd = 13.5 * peso + 487;
                }

            } else
                if (nivelDeAtividade == 1) {
                    if (idade == 1) {
                        ncd = (15.3 * peso + 679) * 1.5;
                    } else if (idade == 2) {
                        ncd = (11.6 * peso + 879) * 1.5;
                    } else {
                        ncd = (13.5 * peso + 487) * 1.5;
                    }
                } else
                    if (nivelDeAtividade == 2) {
                        if (idade == 1) {
                            ncd = (15.3 * peso + 679) * 1.8;
                        } else if (idade == 2) {
                            ncd = (11.6 * peso + 879) * 1.8;
                        } else {
                            ncd = (13.5 * peso + 487) * 1.8;
                        }
                    } else
                        if (nivelDeAtividade == 3) {
                            if (idade == 1) {
                                ncd = (15.3 * peso + 679) * 2.1;
                            } else if (idade == 2) {
                                ncd = (11.6 * peso + 879) * 2.1;
                            } else {
                                ncd = (13.5 * peso + 487) * 2.1;
                            }
                        }
        }
    return ncd;
}








