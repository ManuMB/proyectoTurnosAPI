package com.digitalhouse.turnos.dao;

import java.util.List;

public interface IDao <T>{

    public List<T> listar();
    public T guardar(T t);
    public T buscar(Long id);
    public void eliminar(Long id);
    public T actualizar(T t);       //Es public T ya que devovlería el objeto actualizado, no seria void
}
