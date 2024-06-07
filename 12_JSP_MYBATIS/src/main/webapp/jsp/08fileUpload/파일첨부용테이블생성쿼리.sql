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

comment on column MYFILE.IDX is '일련번호';
comment on column MYFILE.name is '이름';
comment on column MYFILE.TITLE is '제목';
comment on column MYFILE.CATE is '카테고리';
comment on column MYFILE.OFILE is '원본파일명';
comment on column MYFILE.SFILE is '저장된파일명';
comment on column MYFILE.POSTDATE is '등록일';

create sequence SEQ_MYFILE_IDX;
insert into MYFILE (IDX, name, TITLE, CATE, OFILE, SFILE) 
            values(SEQ_MYFILE_IDX.nextval, 'name', 'title', 'cate',  'ofile', 'sfile');
select * from MYFILE;

commit;