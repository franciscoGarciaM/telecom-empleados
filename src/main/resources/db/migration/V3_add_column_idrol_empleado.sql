ALTER TABLE public.empleado ADD id_rol int4 NULL;
ALTER TABLE public.empleado ADD CONSTRAINT empleado_rol_fk FOREIGN KEY (id_rol) REFERENCES public.rol(id_rol);
