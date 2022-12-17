import styles from "../styles/Result.module.css";

export const Result = (props) => {
  const handleClick = () => {
    fetch("http://localhost:8080/simulatefight", {
      method: "POST",
      body: JSON.stringify(props.formEntry),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((data) => {
        props.setResult(data);
      });
  };

  const handleForm = () => {
    props.setResult(null);
  };
  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Commentator's Notes</h1>
      {Object.entries(props.result).map(([key, value]) =>
        (() => {
          let classname = null;
          if (value.includes("Round")) {
            classname = styles.round;
          } else if (value.includes("Tournament")) {
            classname = styles.winner;
          } else {
            classname = null;
          }
          return <p className={classname}>{value}</p>;
        })()
      )}

      <div className={styles.buttonContainer}>
        <button className={styles.button} onClick={handleClick}>
          Retry Battle
        </button>
        <button className={styles.button} onClick={handleForm}>
          Back to Form
        </button>
      </div>
    </div>
  );
};
