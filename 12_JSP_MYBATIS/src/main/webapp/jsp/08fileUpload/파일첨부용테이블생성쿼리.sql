drop table MYFILE;
create table MYFILE(
    IDX number primary key
    , name varchar2(50) not null
    , TITLE varchar2(200)
    , CATE varchar2(100)
    , OFILE varchar2(100)
    , SFILE varchar2(100)
    , POSTDATE date default SYSDATE 
);

comment on column MYFILE.IDX is '�Ϸù�ȣ';
comment on column MYFILE.name is '�̸�';
comment on column MYFILE.TITLE is '����';
comment on column MYFILE.CATE is 'ī�װ�';
comment on column MYFILE.OFILE is '�������ϸ�';
comment on column MYFILE.SFILE is '��������ϸ�';
comment on column MYFILE.POSTDATE is '�����';

create sequence SEQ_MYFILE_IDX;
insert into MYFILE (IDX, name, TITLE, CATE, OFILE, SFILE) 
            values(SEQ_MYFILE_IDX.nextval, 'name', 'title', 'cate',  'ofile', 'sfile');
select * from MYFILE;

commit;