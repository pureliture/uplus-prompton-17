CREATE TABLE qa_board
(
    id	INT ,
    product	VARCHAR(512) COMMENT '상품명',
    question	VARCHAR(512) COMMENT '질문내용',
    answer	VARCHAR(512) COMMENT '답변내용',
    question_type	VARCHAR(512) COMMENT '질문유형',
    created_at TIMESTAMP NOT NULL COMMENT '생성일시',
    modified_at TIMESTAMP NOT NULL COMMENT '수정일시'
);